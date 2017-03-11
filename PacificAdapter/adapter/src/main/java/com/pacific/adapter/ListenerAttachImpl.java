package com.pacific.adapter;

import android.support.annotation.IdRes;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

public final class ListenerAttachImpl implements ListenerAttach {
    /**
     * listeners provider
     */
    private final ListenerProvider provider;

    /**
     * item view
     */
    private final View itemView;

    /**
     * adapter position
     */
    private int position = -1;

    /**
     * item
     */
    private Item item;

    public ListenerAttachImpl(ListenerProvider provider, View itemView) {
        this.provider = provider;
        this.itemView = itemView;
    }

    /**
     * set adapter position
     *
     * @param position
     */
    public void setCurrentPosition(int position) {
        this.position = position;
    }

    /**
     * set item
     *
     * @param item
     */
    public void setCurrentItem(Item item) {
        this.item = item;
    }

    /**
     * attach OnClickListener for view
     *
     * @param viewId view id
     */
    public void attachOnClickListener(int viewId) {
        final View.OnClickListener listener = provider.getOnClickListener(item.getLayout());
        if (listener == null) return;
        View view = AdapterUtil.findView(itemView, viewId);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTags(v);
                listener.onClick(v);
            }
        });
    }

    /**
     * attach OnTouchListener for view
     *
     * @param viewId view id
     */
    public void attachOnTouchListener(int viewId) {
        final View.OnTouchListener listener = provider.getOnTouchListener(item.getLayout());
        if (listener == null) return;
        View view = AdapterUtil.findView(itemView, viewId);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                setTags(v);
                return listener.onTouch(v, event);
            }
        });
    }

    /**
     * attach OnLongClickListener for view
     *
     * @param viewId view id
     */
    public void attachOnLongClickListener(int viewId) {
        final View.OnLongClickListener listener = provider.getOnLongClickListener(item.getLayout());
        if (listener == null) return;
        View view = AdapterUtil.findView(itemView, viewId);
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                setTags(v);
                return listener.onLongClick(v);
            }
        });
    }

    /**
     * attach CompoundButton.OnCheckedChangeListener for CompoundButton
     *
     * @param viewId CompoundButton view id
     */
    public void attachOnCheckedChangeListener(int viewId) {
        final CompoundButton.OnCheckedChangeListener listener = provider
                .getOnCheckedChangeListener(item.getLayout());
        if (listener == null) return;
        CompoundButton view = AdapterUtil.findView(itemView, viewId);
        view.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setTags(buttonView);
                listener.onCheckedChanged(buttonView, isChecked);
            }
        });
    }


    /**
     * set RadioGroup.OnCheckedChangeListener for RadioGroup
     *
     * @param viewId RadioGroup view id
     */
    public void attachGroupOnCheckedChangeListener(int viewId) {
        final RadioGroup.OnCheckedChangeListener listener = provider
                .getGroupOnCheckedChangeListener(item.getLayout());
        if (listener == null) return;
        RadioGroup view = AdapterUtil.findView(itemView, viewId);
        view.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                setTags(group);
                listener.onCheckedChanged(group, checkedId);
            }
        });
    }

    private void setTags(View view) {
        AdapterUtil.setTag(view, position);
        AdapterUtil.setTag(view, item);
        AdapterUtil.setTag(view, itemView);
    }
}
