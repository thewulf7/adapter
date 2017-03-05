/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pacific.adapter.core;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ViewHolder extends RecyclerView.ViewHolder implements ListenerAttach {

    private Object binding;

    /**
     * adapter position
     */
    private int position = -1;

    /**
     * item
     */
    private Item item;

    /**
     * ListenerAttach
     */
    private final ListenerAttachImpl listenerAttach;

    public ViewHolder(View itemView, ListenerProvider provider) {
        super(itemView);
        this.listenerAttach = new ListenerAttachImpl(provider, itemView);
        try {
            Class.forName("android.databinding.ViewDataBinding");
            binding = DataBindingUtil.bind(itemView);
        } catch (ClassNotFoundException e) {
            binding = new SimpleViewDataBinding(itemView);
        }
    }

    void setCurrentPosition(int position) {
        this.position = position;
        this.listenerAttach.setCurrentPosition(position);
    }

    public int getCurrentPosition() {
        return position;
    }

    void setCurrentItem(Item item) {
        this.item = item;
        this.listenerAttach.setCurrentItem(item);
    }

    public <T extends Object> T binding() {
        return (T) this.binding;
    }

    /**
     * attach OnClickListener for view
     *
     * @param viewId view id
     */
    @Override
    public void attachOnClickListener(int viewId) {
        listenerAttach.attachOnClickListener(viewId);
    }

    /**
     * attach OnTouchListener for view
     *
     * @param viewId view id
     */
    @Override
    public void attachOnTouchListener(int viewId) {
        listenerAttach.attachOnTouchListener(viewId);
    }

    /**
     * attach OnLongClickListener for view
     *
     * @param viewId view id
     */
    @Override
    public void attachOnLongClickListener(int viewId) {
        listenerAttach.attachOnLongClickListener(viewId);
    }

    /**
     * attach CompoundButton.OnCheckedChangeListener for CompoundButton
     *
     * @param viewId CompoundButton view id
     */
    @Override
    public void attachOnCheckedChangeListener(int viewId) {
        listenerAttach.attachOnCheckedChangeListener(viewId);
    }

    /**
     * set RadioGroup.OnCheckedChangeListener for RadioGroup
     *
     * @param viewId RadioGroup view id
     */
    @Override
    public void attachGroupOnCheckedChangeListener(int viewId) {
        listenerAttach.attachGroupOnCheckedChangeListener(viewId);
    }
}
