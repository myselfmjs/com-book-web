package proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: majunsheng
 * @Date: 2018/9/17
 **/
public class CglibFactory {

    public static UserDao createService() {

        //目标类
        final UserDao userDao = new UserDao();
        //核心类
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(userDao.getClass());

        /* 设置回调函数 , MethodInterceptor接口 等效 jdk InvocationHandler接口
         *  intercept() 等效 jdk  invoke()
                *      参数1、参数2、参数3：以invoke一样
                *      参数4：methodProxy 方法的代理
         *
         *
         */
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

                System.out.println("在 代理对象 前拦截到："+method.getName());
                //执行目标类的方法
                Object obj = method.invoke(userDao, args);
                // * 执行代理类的父类 ，执行目标类 （目标类和代理类 父子关系）
                methodProxy.invokeSuper(proxy, args);
                System.out.println("在 代理对象 后拦截到："+method.getName());
                return obj;
            }
        });
        //3.4 创建代理
        UserDao proxService = (UserDao) enhancer.create();

        return proxService;
    }

}
