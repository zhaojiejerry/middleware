package com.example.demo.ESService;

import com.example.demo.ESRepository.UserRepository;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.util.JsonUtils;
import com.google.common.collect.Lists;
import org.elasticsearch.action.update.UpdateRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * author:lizhaojie
 * 创建日期:2019/9/27-15:03
 */
@Service
public class UserStandardService  implements StandardService {
    @Resource
    private UserRepository userRepository;

    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;
    /**
     * 批量新增
     **/
    @Override
    public void batchAddUser(List<User> users) {
        if(CollectionUtils.isEmpty(users)) {
            return ;
        }
        List<IndexQuery> queries = Lists.newArrayListWithExpectedSize(users.size());
        IndexQuery indexItem  = null;
        for(User user :users) {
            indexItem = new IndexQuery();
            indexItem.setObject(user);
            queries.add(indexItem);
        }
        elasticsearchTemplate.bulkIndex(queries);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deletedUserById(String id) {
        userRepository.deleteById(id);
    }

    /**
     * 根据userId更新信息
     */
    @Override
    public void updateUser(User user) {
        UpdateQuery updateQuery = new UpdateQuery();
        updateQuery.setId(user.getId());
        updateQuery.setClazz(User.class);
        user.setId(null);
        UpdateRequest request = new UpdateRequest();
        request.doc(JsonUtils.objectToJson(user));
        updateQuery.setUpdateRequest(request);
        elasticsearchTemplate.update(updateQuery);
    }

    @Override
    public List<User> queryByUserName(String userName) {
        return userRepository.findByUserNameLike(userName);
    }

    @Override
    public List<User> queryByRoleName(Role role) {
        return userRepository.findByRoles_Name(role.getName());
    }

}
