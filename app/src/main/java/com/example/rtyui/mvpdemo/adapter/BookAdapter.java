package com.example.rtyui.mvpdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rtyui.mvpdemo.R;
import com.example.rtyui.mvpdemo.bean.Book;

import java.util.List;

/**
 * Created by rtyui on 2018/4/22.
 */

public class BookAdapter extends BaseAdapter {

    private List<Book> books = null;
    private Context context = null;

    public BookAdapter(Context context, List<Book> books){
        this.context = context;
        this.books = books;
    }

    @Override
    public int getCount() {
        if (books == null)
            return 0;
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item, null, false);
            viewHolder.txtId = convertView.findViewById(R.id.txt_id);
            viewHolder.txtName = convertView.findViewById(R.id.txt_name);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txtId.setText(books.get(position).id + "");
        viewHolder.txtName.setText(books.get(position).name);
        return convertView;
    }

    private class  ViewHolder{
        public TextView txtId;
        private TextView txtName;
    }
}
