package com.example.demo.Service;


import com.example.demo.entity.Application;

import java.util.List;

/**
 * author:lizhaojie
 * 创建日期:2019/9/24-15:49
 */
public interface ApplicationService {

    List<Application> getAllApplications();

    int addApplication(Application application);

    Application getApplicationById(String id);
}
