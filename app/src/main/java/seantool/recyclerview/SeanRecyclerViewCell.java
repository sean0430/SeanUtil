
/*
 *  Copyright (C) 2016 by Sean Lin
 *
 *  ALL RIGHTS RESERVED
 *
 *
 */

package seantool.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * SeanUtilSample
 * Created by Sean on 2016/7/15下午4:18.
 */
public abstract class SeanRecyclerViewCell extends RelativeLayout
        implements View.OnClickListener {

    private OnItemClickListener onItemClickListener;
    private Context context;

    public SeanRecyclerViewCell(Context context) {
        super(context);
    }

    public SeanRecyclerViewCell(Context context, int layoutId) {
        super(context);
        this.context = context;
        setLayout(layoutId);
    }


    private void setLayout(int layoutId) {
        LayoutInflater lf =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        addView(lf.inflate(layoutId, null));
        setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (onItemClickListener != null) {
            onItemClickListener.onClick();
        }
    }

    public interface OnItemClickListener {
        void onClick();
    }

    @SuppressWarnings("unused")
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public abstract void bindData(Object object);
}
