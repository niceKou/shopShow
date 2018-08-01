package com.niceKou.module.dao;

import com.niceKou.module.domain.Demo;

import java.util.List;

public interface DemoDao {
    public Integer addUser(Demo user);

    public Demo getUserById(Integer userId);

    public List<Demo> listAllUser();

    public Integer deleteUser(Integer userId);

}
