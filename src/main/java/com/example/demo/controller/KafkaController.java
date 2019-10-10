package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * author:lizhaojie
 * 创建日期:2019/9/27-12:49
 */
@RequestMapping(value = "/kafka")
@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate kafkaTemplate;
    @RequestMapping("send")
    @ResponseBody
    public String  sengMessage(HttpServletRequest request, HttpServletResponse response){
        String message = request.getParameter("message");
        try {
            kafkaTemplate.send("test",message);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return  "error";
        }
    }
}
