package com.pacific.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class ViewPagerAdapter<T> extends BaseViewPagerAdapter<T, PagerAdapterHelper> {
    public ViewPagerAdapter(Context context, int layoutResId) {
        super(context, layoutResId);
    }

    public ViewPagerAdapter(Context context, int layoutResId, List<T> data) {
        super(context, layoutResId, data);
    }

    @Override
    protected PagerAdapterHelper getAdapterHelper(int position, View convertView, ViewGroup parent) {
        return PagerAdapterHelper.get(context, convertView, parent, layoutResId, position);
    }
}
