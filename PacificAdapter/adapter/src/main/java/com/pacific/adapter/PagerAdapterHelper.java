package com.pacific.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

final public class PagerAdapterHelper extends BaseAdapterHelper<PagerAdapterHelper> {

    protected View convertView;
    protected int position = -1;

    private PagerAdapterHelper(Context context, ViewGroup parent, int layoutId, int position) {
        this.position = position;
        this.views = new SparseArray<>();
        this.convertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        this.convertView.setTag(this);
        parent.addView(this.convertView);
    }

    static PagerAdapterHelper get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new PagerAdapterHelper(context, parent, layoutId, position);
        }
        PagerAdapterHelper helper = (PagerAdapterHelper) convertView.getTag();
        helper.position = position;
        parent.addView(convertView);
        return helper;
    }

    @Override
    public View getItemView() {
        return convertView;
    }

    public int getPosition() {
        return position;
    }
}
