package proxy.cglib;

import com.book.web.pojo.User;

/**
 * @Author: majunsheng
 * @Date: 2018/9/17
 **/
public class TestCglibProxy {

    public static void main(String[] args) {

        UserDao userDao = CglibFactory.createService();
        userDao.add();
    }
}
