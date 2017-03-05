package com.example.demo.entity;

import com.example.demo.R;
import com.pacific.adapter.SimpleItem;
import com.pacific.adapter.SimpleViewDataBinding;
import com.pacific.adapter.ViewHolder;

public class ExampleItem extends SimpleItem {
    private String title;

    public String getTitle() {
        return title;
    }

    public ExampleItem(String title) {
        this.title = title;
    }

    @Override
    public int getLayout() {
        return R.layout.item_list_view;
    }

    @Override
    public void bind(ViewHolder holder) {
        SimpleViewDataBinding binding = holder.binding();
        binding.setText(R.id.text, title);
        holder.attachOnClickListener(R.id.text);
    }
}
