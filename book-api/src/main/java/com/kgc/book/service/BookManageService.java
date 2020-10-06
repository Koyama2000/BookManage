package com.kgc.book.service;

import com.kgc.book.bean.BookManage;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

public interface BookManageService {
    //查询全部
    public List<BookManage> BOOK_LIST();
    //删除
    public int DEL_BOOK(int id);
    //添加
    public int ADD_BOOK(BookManage bookManage);
}
