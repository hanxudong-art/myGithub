package com.han.service;

import com.han.dao.BookMapper;
import com.han.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;   //注入mapper层

    //重写mapper层方法
    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books queryBooKById(int id) {
        return bookMapper.queryBooKById(id);
    }

    @Override
    public Books queryBooKByName(String bookName) {
        return bookMapper.queryBooKByName(bookName);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }
}
