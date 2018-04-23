package com.example.rtyui.mvpdemo.model;

import com.example.rtyui.mvpdemo.bean.Book;
import com.example.rtyui.mvpdemo.contract.BookContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rtyui on 2018/4/22.
 */

public class BookModel implements BookContract.Model{

    public List<Book> books = new ArrayList<>();

    @Override
    public List<Book> load() {
        books.add(new Book(0, "书本0"));
        books.add(new Book(1, "书本1"));
        return books;
    }

    @Override
    public void add() {
        books.add(new Book(books.size(), "书本" + books.size()));
    }
}
