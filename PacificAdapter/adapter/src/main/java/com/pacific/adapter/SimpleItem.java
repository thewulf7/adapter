package com.pacific.adapter;

public abstract class SimpleItem implements Item<SimpleViewHolder> {
    @Override
    public int getViewType() {
        return 0;
    }

    @Override
    public void unbind(SimpleViewHolder holder) {
    }
}
