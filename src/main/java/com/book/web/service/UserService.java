package com.book.web.service;

import com.book.web.pojo.raw.Admin;

import java.util.List;

/**
 * Created by majunsheng on 2017/3/14.
 */
public interface UserService {

    /**
     * 登录用户一览
     */
    List<Admin> setListPage();
}
