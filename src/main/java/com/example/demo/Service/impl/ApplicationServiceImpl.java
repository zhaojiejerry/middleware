package com.example.demo.Service.impl;

import com.example.demo.Service.ApplicationService;
import com.example.demo.dao.ApplicationDAO;
import com.example.demo.entity.Application;
import com.example.demo.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:lizhaojie
 * 创建日期:2019/9/24-15:50
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    ApplicationDAO applicationDAO;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public List<Application> getAllApplications() {
        return applicationDAO.getList();
    }

    @Override
    public int addApplication(Application application) {
        int i =  applicationDAO.insertApplication(application);
        if(i>0){
            redisTemplate.opsForValue().set("application : "+application.getId(), JsonUtils.objectToJson(application));
        }
        return i;
    }

    @Override
    public Application getApplicationById(String id) {
        Application result = JsonUtils.jsonToPoJo(redisTemplate.opsForValue().get("application : "+id),Application.class);
        if(result == null){
            result = applicationDAO.getApplicationById(id);
            redisTemplate.opsForValue().set("application : "+result.getId(), JsonUtils.objectToJson(result));
        }
        return result;
    }
}
