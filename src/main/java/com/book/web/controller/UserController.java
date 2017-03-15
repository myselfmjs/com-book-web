package com.book.web.controller;


import com.book.web.common.JsonResponseEntity;
import com.book.web.pojo.User;
import com.book.web.pojo.raw.Admin;
import com.book.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by majunsheng on 2017/3/9.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {


    @Autowired
     UserService userService;

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
        List<Admin> admin = userService.setListPage();
        model.addAttribute("admin",admin);
        return "userLogin";
    }


    /**
     * 退出登录
     * @param request
     * @return
     */
    @RequestMapping(value = "/deleteLogin",method = RequestMethod.GET)
    public String DeleteLogin(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/user/login";
    }

    @RequestMapping(value = "/index",method = RequestMethod.POST)
   // @ResponseBody
    public  void Index(@RequestParam(required = false) String id,
                         HttpServletRequest request,HttpServletResponse response){
        System.out.println("过来了");
        String result = "{\"name\":\"" + id+ "\"}";
        PrintWriter out = null;
        System.out.println(result);
        //修改协议头,声明返回json格式.然后输出
        response.setContentType("application/json");
        try {
            out = response.getWriter();
            out.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public  Admin List(Model model,@RequestParam(required = false) String id){
        JsonResponseEntity<Object> response = new JsonResponseEntity();
        Admin admin =null;
        try {
             //admin = userService.setListPage();
            model.addAttribute("admin",admin);
            response.setCode(1);
        }catch (Exception e){
            response.setCode(0);
            e.printStackTrace();
        }
         return admin;
    }
}
