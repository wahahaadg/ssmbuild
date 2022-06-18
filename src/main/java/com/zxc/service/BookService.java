package com.zxc.service;

import com.zxc.pojo.Books;

import java.util.List;

public interface BookService {
    //增加一本书
    void addBook(Books books);
    //删除一本书
    void deleteBookById(int id);
    //更新一本书
    void updateBook(Books books);
    //查询一本书
    Books queryBookById(int id);
    //查询全部书
    List<Books> queryAllBook();
    Books queryBookByName(String bookName);
}
