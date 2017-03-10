package com.book.web.controller;


import com.book.web.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by majunsheng on 2017/3/9.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    /**
     * 登录校验
     * @param request
     * @param response
     * @param user
     * @return
     */
    @RequestMapping(value = "/doLogin")
    public String DoLogin(HttpServletRequest request, HttpServletResponse response,User user){
        User user1 =(User) request.getSession().getAttribute("user");
        if(user1 == null) {
            request.getSession().setAttribute("user",user);
          /*  Cookie userName = new Cookie("userName", user.getUsername());
            Cookie password = new Cookie("password", user.getPassword());
            userName.setMaxAge(0);
            userName.setPath("/");
            password.setMaxAge(0);
            password.setPath("/");
            response.addCookie(userName);
            response.addCookie(password);*/
        }
        return "redirect:/user/login";
    }

    /**
     * 跳转登录页面
     * @param request
     * @param response
     * @param model
     * @param user
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String UserLogin(HttpServletRequest request, HttpServletResponse response, Model model, User user){


        model.addAttribute("userName", ((User) request.getSession().getAttribute("user")).getUsername());

        return "userLogin";
    }


    /**
     * 退出登录
     * @param request
     * @return
     */
    @RequestMapping(value = "deleteLogin",method = RequestMethod.GET)
    public String DeleteLogin(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/user/login";
    }
}
