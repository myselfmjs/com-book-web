package com.book.web.mapper.raw;

import com.book.web.pojo.raw.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {
    int deleteByPrimaryKey(String id);

    int insert(Book record);

    int insertSelective(Book record);

    List<Book> selectById(String id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}