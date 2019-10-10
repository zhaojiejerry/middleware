package com.example.demo.ESRepository;

import com.example.demo.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * author:lizhaojie
 * 创建日期:2019/9/27-14:59
 */
public interface UserRepository extends ElasticsearchRepository<User,String> {

    //按userName like查询
    List<User> findByUserNameLike(String userName);

    //按role的name属性查询
    List<User> findByRolesName(String name);

    //按role的name属性查询 两种方式都可以
    List<User> findByRoles_Name(String name);

}
