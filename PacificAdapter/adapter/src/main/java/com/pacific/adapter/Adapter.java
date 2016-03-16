package com.pacific.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class Adapter<T> extends BaseAdapter<T, AdapterHelper> {

    public Adapter(Context context, int layoutResId) {
        super(context, layoutResId);
    }

    public Adapter(Context context, int layoutResId, List<T> data) {
        super(context, layoutResId, data);
    }

    protected AdapterHelper getAdapterHelper(int position, View convertView, ViewGroup parent) {
        return AdapterHelper.get(context, convertView, parent, layoutResId, position);
    }

}
