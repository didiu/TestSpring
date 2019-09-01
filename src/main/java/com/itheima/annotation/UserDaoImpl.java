package com.itheima.annotation;

import org.springframework.stereotype.Repository;

@Repository("userDao1")
public class UserDaoImpl implements UserDao{
    public void save(){
        System.out.println("userdao...save");
    }
}
