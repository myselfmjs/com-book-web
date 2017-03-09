package com.book.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by majunsheng on 2017/3/9.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String UserLogin(){
        return "userLogin";
    }
}
