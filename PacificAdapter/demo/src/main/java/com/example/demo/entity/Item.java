package com.example.demo.entity;

import com.example.demo.R;
import com.pacific.adapter.DefaultBinding;
import com.pacific.adapter.SimpleItem;
import com.pacific.adapter.ViewHolder;

public class Item extends SimpleItem {
    private String title;

    public String getTitle() {
        return title;
    }

    public Item(String title) {
        this.title = title;
    }

    @Override
    public int getLayout() {
        return R.layout.item;
    }

    @Override
    public void bind(ViewHolder holder) {
        DefaultBinding binding = holder.binding();
        binding.setText(R.id.text, title);
        holder.attachOnClickListener(R.id.text);
    }
}
