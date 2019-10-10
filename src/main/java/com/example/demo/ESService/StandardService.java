package com.example.demo.ESService;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;

import java.util.List;

/**
 * author:lizhaojie
 * 创建日期:2019/9/27-15:11
 */
public interface StandardService {

    public void batchAddUser(List<User> users);

    public void addUser(User user);

    public void deletedUserById(String id);

    public void updateUser(User user);

    public List<User> queryByUserName(String userName);

    public List<User> queryByRoleName(Role role);
}
