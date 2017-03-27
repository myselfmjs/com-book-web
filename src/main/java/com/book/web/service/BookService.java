package com.book.web.service;

import com.book.web.pojo.raw.Book;

import java.util.List;

/**
 * Created by majunsheng on 2017/3/26.
 */
public interface BookService {

    public List<Book> findById(String id);
}
