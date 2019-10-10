package com.example.demo.controller;

import com.example.demo.ESRepository.UserRepository;
import com.example.demo.ESService.UserStandardService;
import com.example.demo.entity.User;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * author:lizhaojie
 * 创建日期:2019/9/27-16:14
 */
@RestController
public class ElasticSearchController {
    @Resource
    private UserStandardService userService;
    @Resource
    private UserRepository userRepository;
    @Resource
    private TransportClient client;

    @PostMapping("user/add")
    public void addUser(@RequestBody  User user) {
        userService.addUser(user);
        System.out.println(user.toString());
    }

    @GetMapping("getUser")
    public List<User> findUser(){
       return userService.queryByUserName("陈晓军");
    }
}
