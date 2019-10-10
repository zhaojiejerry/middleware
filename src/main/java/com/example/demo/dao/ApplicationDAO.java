package com.example.demo.dao;

import com.example.demo.entity.Application;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface ApplicationDAO {

    Application getApplicationById(String id);

    int insertApplication(Application application);

    List<Application> getList();
}
