package com.example.demo.controller;

import com.example.demo.Service.ApplicationService;
import com.example.demo.entity.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author:lizhaojie
 * 创建日期:2019/9/24-15:47
 */
@RequestMapping(value = "/app")
@RestController
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @PostMapping(value = "/add")
    public void  addApplication(@RequestBody Application application){
        applicationService.addApplication(application);
    }
    @GetMapping(value = "/list")
    public List<Application> findAllApplication(){
        return  applicationService.getAllApplications();
    }

}
