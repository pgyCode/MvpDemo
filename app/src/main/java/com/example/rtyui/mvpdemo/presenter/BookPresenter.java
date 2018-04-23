package com.example.rtyui.mvpdemo.presenter;

import android.os.AsyncTask;

import com.example.rtyui.mvpdemo.bean.Book;
import com.example.rtyui.mvpdemo.contract.BookContract;
import com.example.rtyui.mvpdemo.model.BookModel;

import java.util.List;

/**
 * Created by rtyui on 2018/4/22.
 */

public class BookPresenter implements BookContract.Presenter {

    private BookModel bookModel = null;
    private BookContract.View view = null;

    public BookPresenter(BookContract.View view){
        this.bookModel = new BookModel();
        this.view = view;
    }

    @Override
    public void load() {
        new AsyncTask<List<Book>, Void, List<Book>>(){
            @Override
            protected List<Book> doInBackground(List<Book>[] lists) {
                return bookModel.load();
            }

            @Override
            protected void onPostExecute(List<Book> books) {
                super.onPostExecute(books);
                view.loadShow(books);
            }
        }.execute();
    }

    @Override
    public void add() {
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                bookModel.add();
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                view.addShow();
            }
        }.execute();
    }
}
