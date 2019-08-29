package com.itheima.annotation;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("userController")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    private static Logger log= Logger.getLogger(UserController.class);

    public void save(){
        this.userService.save();
        log.info("userController ...save");
        System.out.println("userController ...save");
    }
}
