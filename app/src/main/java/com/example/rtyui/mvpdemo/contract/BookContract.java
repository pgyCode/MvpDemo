package com.example.rtyui.mvpdemo.contract;

import com.example.rtyui.mvpdemo.bean.Book;

import java.util.List;

/**
 * Created by rtyui on 2018/4/22.
 */

public interface BookContract {
    interface View{
        void loadShow(List<Book> books);
        void addShow();
    }

    interface Presenter{
        void load();
        void add();
    }

    interface Model{
        List<Book> load();
        void add();
    }
}
