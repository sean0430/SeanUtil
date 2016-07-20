
package com.sean.nanastudio.seanutilsample;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import seantool.recyclerview.SeanRecyclerViewCell;

/**
 * SeanUtilSample
 * Created by Sean on 2016/7/18上午11:09.
 */
public class RecyclerViewCell extends SeanRecyclerViewCell {

    public RecyclerViewCell(Context context) {
        super(context);
    }

    public RecyclerViewCell(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void bindData(Object object) {

        MockDataInfo mockDataInfo = (MockDataInfo) object;
        TextView tvTest = (TextView) findViewById(R.id.tvText);
        tvTest.setText(String.valueOf(mockDataInfo.getSerialID()));

        Button btnTest = (Button) findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(),"Button on click..",Toast.LENGTH_SHORT).show();
            }
        });


    }


}
