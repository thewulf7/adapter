package com.pacific.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

abstract class BaseAdapter<T, H extends AdapterHelper> extends android.widget.BaseAdapter implements DataIO<T> {

    protected final Context context;
    protected final int layoutResId;
    protected final ArrayList<T> data;

    public BaseAdapter(Context context, int layoutResId) {
        this(context, layoutResId, null);
    }

    public BaseAdapter(Context context, int layoutResId, List<T> data) {
        this.data = data == null ? new ArrayList<T>() : new ArrayList<>(data);
        this.context = context;
        this.layoutResId = layoutResId;
    }

    @Override
    public int getCount() {
        return getSize();
    }

    @Override
    public T getItem(int position) {
        return get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        H helper = getAdapterHelper(position, convertView, parent);
        T item = getItem(position);
        convert(helper, item);
        return helper.getItemView();
    }

    @Override
    public boolean isEnabled(int position) {
        return position < data.size();
    }

    @Override
    public void add(T elem) {
        data.add(elem);
        notifyDataSetChanged();
    }

    @Override
    public void addAt(int location, T elem) {
        data.add(location, elem);
        notifyDataSetChanged();
    }

    @Override
    public void addAll(List<T> elements) {
        data.addAll(elements);
        notifyDataSetChanged();
    }

    @Override
    public void addAllAt(int location, List<T> elements) {
        data.addAll(location, elements);
        notifyDataSetChanged();
    }

    @Override
    public void remove(T elem) {
        data.remove(elem);
        notifyDataSetChanged();
    }

    @Override
    public void removeAt(int index) {
        data.remove(index);
        notifyDataSetChanged();
    }

    @Override
    public void removeAll(List<T> elements) {
        data.removeAll(elements);
        notifyDataSetChanged();
    }

    @Override
    public void clear() {
        if (data != null && data.size() > 0) {
            data.clear();
            notifyDataSetChanged();
        }
    }

    @Override
    public void replace(T oldElem, T newElem) {
        replaceAt(data.indexOf(oldElem), newElem);
    }

    @Override
    public void replaceAt(int index, T elem) {
        data.set(index, elem);
        notifyDataSetChanged();
    }

    @Override
    public void replaceAll(List<T> elements) {
        if (data.size() > 0) {
            data.clear();
        }
        data.addAll(elements);
        notifyDataSetChanged();
    }

    @Override
    public T get(int position) {
        if (position >= data.size())
            return null;
        return data.get(position);
    }

    @Override
    public ArrayList<T> getAll() {
        return data;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public boolean contains(T elem) {
        return data.contains(elem);
    }

    @Override
    public void onEmptyData() {
    }

    @Override
    public void onHasData() {
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        if (getSize() == 0) {
            onEmptyData();
        } else {
            onHasData();
        }
    }

    protected abstract void convert(H helper, T item);

    protected abstract H getAdapterHelper(int position, View convertView, ViewGroup parent);
}
