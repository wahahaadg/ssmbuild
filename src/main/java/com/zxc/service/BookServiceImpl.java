package com.zxc.service;

import com.zxc.mapper.BookMapper;
import com.zxc.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService{
    //service层调用dao层，需要组合dao层
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public void addBook(Books books) {
        bookMapper.addBook(books);
    }

    public void deleteBookById(int id) {
        bookMapper.deleteBookById(id);
    }

    public void updateBook(Books books) {
        bookMapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    public Books queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }

}
