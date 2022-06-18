package com.zxc.mapper;

import com.zxc.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    //增加一本书
    void addBook(Books books);
    //删除一本书
    void deleteBookById(@Param("bookID") int id);
    //更新一本书
    void updateBook(Books books);
    //查询一本书
    Books queryBookById(@Param("bookID")int id);
    //查询全部书
    List<Books> queryAllBook();
    //查询书籍
    Books queryBookByName(@Param("bookName")String bookName);
}
