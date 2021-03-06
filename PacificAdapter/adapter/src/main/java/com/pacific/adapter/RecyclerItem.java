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

package com.pacific.adapter;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public interface RecyclerItem<T extends ViewHolder> extends Item<T> {

    /**
     * for DiffUtil
     */
    AtomicLong ID_COUNTER = new AtomicLong(0);

    /**
     * bind pay loads
     *
     * @param holder   view holder
     * @param payloads data
     */
    void bindPayloads(T holder, List<Object> payloads);

    /**
     * get span size , for GridLayoutManager
     *
     * @param spanCount span
     * @param position  adapter position
     * @return
     */
    int getSpanSize(int spanCount, int position);

    /**
     * onViewAttachedToWindow callback
     *
     * @param holder
     */
    void onViewAttachedToWindow(T holder);

    /**
     * onViewDetachedFromWindow callback
     *
     * @param holder
     */
    void onViewDetachedFromWindow(T holder);

    /**
     * isRecyclable callback
     *
     * @return
     */
    boolean isRecyclable();

    /**
     * @return item id
     */
    long diffId();
}
