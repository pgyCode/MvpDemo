package com.example.rtyui.mvpdemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.rtyui.mvpdemo.R;
import com.example.rtyui.mvpdemo.adapter.BookAdapter;
import com.example.rtyui.mvpdemo.bean.Book;
import com.example.rtyui.mvpdemo.contract.BookContract;
import com.example.rtyui.mvpdemo.presenter.BookPresenter;

import java.util.List;

public class BookActivity extends AppCompatActivity implements BookContract.View {

    private BookAdapter bookAdapter = null;
    private ListView lst = null;
    private BookPresenter bookPresenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookPresenter.add();
            }
        });
        bookPresenter = new BookPresenter(this);
        bookPresenter.load();
    }

    @Override
    public void loadShow(List<Book> books) {
        bookAdapter = new BookAdapter(this, books);
        lst = findViewById(R.id.lst);
        lst.setAdapter(bookAdapter);
    }

    @Override
    public void addShow() {
        bookAdapter.notifyDataSetChanged();
    }
}
