package com.pacific.adapter;

interface ListenerAttach {
    /**
     * attach OnClickListener for view
     *
     * @param viewId view id
     */
    void attachOnClickListener(int viewId);

    /**
     * attach OnTouchListener for view
     *
     * @param viewId view id
     */
    void attachOnTouchListener(int viewId);

    /**
     * attach OnLongClickListener for view
     *
     * @param viewId view id
     */
    void attachOnLongClickListener(int viewId);

    /**
     * attach CompoundButton.OnCheckedChangeListener for CompoundButton
     *
     * @param viewId CompoundButton view id
     */
    void attachOnCheckedChangeListener(int viewId);


    /**
     * set RadioGroup.OnCheckedChangeListener for RadioGroup
     *
     * @param viewId RadioGroup view id
     */
    void attachGroupOnCheckedChangeListener(int viewId);
}
