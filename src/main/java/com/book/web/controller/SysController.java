package com.book.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by majunsheng on 2017/3/9.
 */
@Controller
public class SysController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String Login(){
        System.out.println("----------------Login()-----------------------------------");
        return "login";
    }
}
