package com.example.demo;

import com.example.demo.Kafka.Producer;
import com.example.demo.entity.Apple;
import com.example.demo.util.AppleComparator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@MapperScan("com.example.demo.dao")
@EnableElasticsearchRepositories(basePackages = "com.example.demo.ESRepository")
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors","false");
        SpringApplication.run(DemoApplication.class, args);


//        List<Apple> inventory = new ArrayList<>();
//        inventory.addAll(Arrays.asList(new Apple(80, "green"),
//                new Apple(155, "green"), new Apple(120, "red")));
//        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
//        System.out.println(inventory);
//        String text = "测速";
//
//
//
//        Map<String, List<Apple>> collect = inventory.stream().collect(Collectors.groupingBy(Apple::getColor));
//        System.out.println(collect.toString());
//
//        Map<String,List<Apple>> AppleMap = new HashMap<>();
//
//        for (Apple apple : inventory) {
//            List<Apple> appleList = AppleMap.get(apple.getColor());
//            if (appleList != null) {
//                appleList.add(apple);
//            } else {
//                appleList = new ArrayList<>();
//                appleList.add(apple);
//            }
//            AppleMap.put(apple.getColor(),appleList);
//
//
//        }
//
//        System.out.println("22222" + AppleMap.toString());
//
//        for (Apple apple : inventory){
//            List<Apple> appleList = AppleMap.getOrDefault(apple.getColor(),new ArrayList<>());
//            appleList.add(apple);
//            AppleMap.put(apple.getColor(),appleList);
//        }
//
//        Integer reduce = inventory.stream().map(Apple::getWeight).reduce(0, (a, b) -> a + b);
//        System.out.println(reduce);
//
//        List<String> colorList = inventory.stream().map(Apple::getColor).filter((a) -> a.equals("red")).collect(Collectors.toList());
//
//        System.out.println(colorList.toString());
    }
}