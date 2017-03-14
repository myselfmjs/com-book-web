package com.book.web.service.impl;

import com.book.web.mapper.raw.AdminMapper;
import com.book.web.pojo.raw.Admin;
import com.book.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by majunsheng on 2017/3/14.
 */

@Service("UserService")
public class UserServiceImp implements UserService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin setListPage() {
        Integer integer = 1;
        Admin admin = adminMapper.selectByPrimaryKey(integer);
        return admin;
    }
}
