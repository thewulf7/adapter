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

import android.view.View;

public class AdapterCompact {
    private AdapterCompact() {
        new AssertionError("Not supported");
    }

    /**
     * find view
     *
     * @param view   parent view
     * @param viewId view id
     * @param <V>    view
     * @return
     */
    public static <V extends View> V findView(View view, int viewId) {
        return (V) view.findViewById(viewId);
    }

    /**
     * get adapter position for view tag
     *
     * @param view view
     * @return
     */
    public static int getPosition(View view) {
        try {
            String value = String.valueOf(view.getTag(R.integer.adapter_position));
            return Integer.parseInt(value);
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * get item
     *
     * @param view view
     * @param <T>  {@link Item}
     * @return
     */
    public static <T extends Item> T getItem(View view) {
        try {
            return (T) view.getTag(R.integer.adapter_item);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * get ItemView
     *
     * @param view view
     * @return view's parent,the whole ItemView
     */
    public static View getItemView(View view) {
        try {
            return (View) view.getTag(R.integer.adapter_item_view);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * set adapter position to tag
     *
     * @param view
     * @param position
     */
    static void setTag(View view, int position) {
        view.setTag(R.integer.adapter_position, position);
    }

    /**
     * set item to tag
     *
     * @param view view
     * @param item {@link Item}
     */
    static void setTag(View view, Item item) {
        view.setTag(R.integer.adapter_item, item);
    }

    /**
     * set ItemView to tag
     *
     * @param view     view
     * @param itemView ItemView
     */
    static void setTag(View view, View itemView) {
        view.setTag(R.integer.adapter_item_view, itemView);
    }
}
