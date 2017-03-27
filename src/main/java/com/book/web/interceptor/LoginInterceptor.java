package com.book.web.interceptor;

import com.book.web.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by majunsheng on 2017/3/10.
 *定义自己的拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object pojo) throws Exception {
        User user =(User) request.getSession().getAttribute("user");
        String user1 = request.getParameter("user");
        if(user == null){
            response.sendRedirect("/");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

       // System.out.println("---------------postHandle-------------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

       // System.out.println("---------------afterCompletion-------------------");
    }
}
