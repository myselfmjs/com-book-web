package proxy.cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * @Author: majunsheng
 * @Date: 2018/9/17
 *
 * 此方法并非Cglib
 **/
public class TestDtProxy {

    public static void main(String[] args) {
        final DAOInterface userDao = new UserDao();
         /*
         *  Proxy.newProxyInstance
         *      参数1：loader ，类加载器，动态代理类 运行时创建，任何类都需要类加载器将其加载到内存。
         *          一般情况：当前类.class.getClassLoader();
         *                  目标类实例.getClass().get...
         *      参数2：Class[] interfaces 代理类需要实现的所有接口
         *          方式1：目标类实例.getClass().getInterfaces()  ;注意：只能获得自己接口，不能获得父元素接口
         *          方式2：new Class[]{UserService.class}
         *          例如：jdbc 驱动  --> DriverManager  获得接口 Connection
         *      参数3：InvocationHandler  处理类，接口，必须进行实现类，一般采用匿名内部
         *          提供 invoke 方法，代理类的每一个方法执行时，都将调用一次invoke
         *              参数31：Object proxy ：代理对象
         *              参数32：Method method : 代理对象当前执行的方法的描述对象（反射）
         *                  执行方法名：method.getName()
         *                  执行方法：method.invoke(对象，实际参数)
         *              参数33：Object[] args :方法实际参数
         *
         */
        DAOInterface proxy = (DAOInterface)
                Proxy.newProxyInstance(userDao.getClass().getClassLoader(),
                        userDao.getClass().getInterfaces(), new InvocationHandler() {
                            //回调方法 拦截到目标对象的时候执行
                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                                System.out.println("在 代理对象 前拦截到："+method.getName());
                                Object obj = method.invoke(userDao,args);//调用拦截到的方法
                                System.out.println("在 代理对象 后拦截到："+method.getName());
                                return obj;
                            }
                        });

        proxy.delete();
    }

}
