

/*
 *  Copyright (C) 2016 The Android Open Source Project
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package seantool.recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * SeanUtilSample
 * Created by Sean on 2016/7/15下午4:18.
 */
public abstract class SeanRecyclerViewCell extends RelativeLayout
        implements View.OnClickListener, View.OnTouchListener,
        View.OnLongClickListener {

    private View view;
    private Context context;
    private int layoutId;
    private int viewType;

    private OnItemTouchListener onItemTouchListener;
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;

    public SeanRecyclerViewCell(Context context) {
        super(context);
        initial();
    }

    public SeanRecyclerViewCell(Context context, int layoutId) {
        super(context);
        this.context = context;
        this.layoutId = layoutId;
        initial();
    }

    public SeanRecyclerViewCell(Context context, int layoutId, int viewType) {
        super(context);
        this.context = context;
        this.layoutId = layoutId;
        this.viewType = viewType;
        initial();

    }

    private void initial() {
        setLayout(context, layoutId);
        setListener();
        setDescendantFocusability(FOCUS_AFTER_DESCENDANTS);
        this.setBackgroundColor(Color.WHITE);
    }

    private void setLayout(Context context, int layoutId) {
        LayoutInflater lf =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = lf.inflate(layoutId, null);
        addView(view);
    }

    private void setListener() {
        setOnTouchListener(this);
        setOnClickListener(this);
        setOnLongClickListener(this);
    }

    public abstract void bindData(Object object);

    public int getViewType() {
        return viewType;
    }

    //Touch event
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (onItemTouchListener != null)
                    onItemTouchListener.onActionDown();
                return false;

            case MotionEvent.ACTION_UP:
                if (onItemTouchListener != null)
                    onItemTouchListener.onActionUp();
                return false;

            default:
                return false;
        }

    }

    public interface OnItemTouchListener {
        void onActionDown();

        void onActionUp();
    }

    public void setOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.onItemTouchListener = onItemTouchListener;
    }


    //Click event
    @Override
    public void onClick(View view) {

        if (onItemClickListener != null) {
            onItemClickListener.onClick();
        }
    }

    public interface OnItemClickListener {
        void onClick();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    //Long click event
    @Override
    public boolean onLongClick(View view) {
        if (onItemLongClickListener != null) {
            onItemLongClickListener.onItemLongClick();
        }
        return true;
    }

    public interface OnItemLongClickListener {
        void onItemLongClick();
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }
}
