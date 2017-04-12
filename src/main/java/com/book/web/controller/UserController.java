package com.book.web.controller;


import com.book.web.common.JsonResponseEntity;
import com.book.web.pojo.User;
import com.book.web.pojo.raw.Admin;
import com.book.web.pojo.raw.Book;
import com.book.web.service.BookService;
import com.book.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    BookService bookService;

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
        String username = user.getUsername().trim();
        String password = user.getPassword().trim();
        if(user != null) {
            request.getSession().setAttribute("user",user);
            if("book".equals(username) && "book".equals(password)){
                return "redirect:/user/book";
            }else {
                return "redirect:/user/login";
            }
        }
        return null;
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
        return "userLogin"; //用户登录成功
       // return "sortArray/inArray"; //数组排序
        //return "prototype/prototype"; //prototype属性
       // return "prototype/bibao"; //jquery闭包
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
        Admin admin =new Admin();
        admin.setUsername("userName");
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


    /**
     * BOOK一览页面
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "book",method = RequestMethod.GET)
    public String index(Model model,String id){
        List<Book> bookList = bookService.findById(id);
        model.addAttribute("book",bookList);
        return  "book/bookList";
    }


    /**
     * 获取BOOK一览数据
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "bookList",method = RequestMethod.POST)
    @ResponseBody
    public Book list(Model model, @RequestParam(required = false) String id){
        List<Book> bookList = bookService.findById(id);
        return null;
    }

    @RequestMapping(value = "downList",method = RequestMethod.GET)
    public String downList(Model model,@RequestParam(required = false) String id){
        return "download/downFile";
    }
}
