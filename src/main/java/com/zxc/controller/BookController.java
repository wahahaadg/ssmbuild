package com.zxc.controller;

import com.zxc.pojo.Books;
import com.zxc.service.BookService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    //controller层调用service层

    private final BookService bookService;
    //
    public BookController(@Qualifier("BookServiceImpl") BookService bookService) {
        this.bookService = bookService;
    }

    //查询全部的书籍并且返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }

    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }
    //增加书籍的请求
    @RequestMapping("addBook")
    public String addPaper(Books books){
        System.out.println(books);
        bookService.addBook(books);
        //增加后跳转到查询全部书籍页面
        return "redirect:/book/allBook";
    }

    //跳转到修改界面
    @RequestMapping("toUpdateBook")
    public String toUpdatePaper(int id, Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("book",books);
        return "updateBook";
    }
    //修改书籍
    @RequestMapping("updateBook")
    public String updateBook(Books books){
        System.out.println(books);
        bookService.updateBook(books);
        //增加后跳转到查询全部书籍页面
        return "redirect:/book/allBook";
    }

    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        //增加后跳转到查询全部书籍页面
        return "redirect:/book/allBook";
    }

    //查询书籍
    @RequestMapping("queryBook")
    public String queryBook(String queryBookName, Model model){
        Books books = bookService.queryBookByName(queryBookName);
        List<Books> list = new ArrayList<Books>();
        list.add(books);
        model.addAttribute("list",list);
        return "allBook";
    }
}
