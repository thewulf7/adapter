package com.pacific.adapter;

public abstract class SimpleItem implements Item<ViewHolder> {
    @Override
    public int getViewType() {
        return 0;
    }

    @Override
    public void unbind(ViewHolder holder) {
    }
}