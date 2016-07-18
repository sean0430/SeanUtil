package com.sean.nanastudio.seanutilsample;

import android.content.Context;
import android.widget.TextView;

import seantool.SeanRecyclerViewCell;

/**
 * SeanUtilSample
 * Created by Sean on 2016/7/18上午11:09.
 */
public class RecyclerViewCell extends SeanRecyclerViewCell {

    private static final String TAG = "RecyclerViewCell";

    public RecyclerViewCell(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void bindData(Object object) {
        final MockDataInfo mockDataInfo = (MockDataInfo) object;
        TextView tvTest = (TextView) findViewById(R.id.tvText);
        tvTest.setText(String.valueOf(mockDataInfo.getSerialID()));

    }


}
