package com.itheima.annotation;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("userService1")
public class UserServiceImpl implements UserService{

    @Resource(name = "userDao1")
    private UserDao userDao;
    public void save(){
        this.userDao.save();
        System.out.println("userservice...save...");
    }
}
