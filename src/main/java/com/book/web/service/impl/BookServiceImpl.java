package com.book.web.service.impl;

import com.book.web.mapper.raw.BookMapper;
import com.book.web.pojo.raw.Book;
import com.book.web.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by majunsheng on 2017/3/26.
 */
@Service("BookService")
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> findById(String id) {
        List<Book> bookList = bookMapper.selectById(id);
        return bookList;
    }
}
