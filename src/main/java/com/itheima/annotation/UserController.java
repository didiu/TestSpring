package com.itheima.annotation;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("userController1")
public class UserController {

    @Resource(name = "userService1")
    private UserService userService;

    private static Logger log= Logger.getLogger(UserController.class);

    public void save(){
        this.userService.save();
        log.info("userController ...save");
        System.out.println("userController ...save");
    }
}
