package com.kgc.book.bookweb.controller;

import com.kgc.book.bean.BookManage;
import com.kgc.book.service.BookManageService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {
    @Reference
    BookManageService bookManageService;

    @RequestMapping("/book/list")
    @ResponseBody
    public List<BookManage> BOOK_LIST(){
        List<BookManage> list = bookManageService.BOOK_LIST();
        return list;
    }

    @RequestMapping("/book/del/By/id")
    @ResponseBody
    public int BOOK_DEL(Integer id){
        return bookManageService.DEL_BOOK(id);
    }

    @RequestMapping("/book/save")
    @ResponseBody
    public int BOOK_SAVE(@RequestBody BookManage bookManage){
        return bookManageService.ADD_BOOK(bookManage);
    }
}
