package com.sean.nanastudio.seanutilsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

import seantool.recyclerview.SeanRecyclerView;
import seantool.recyclerview.SeanRecyclerViewCell;
import seantool.SeanTool;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SeanTool seanTool;
    private final static String TEST_TITLE = "TEST!!";
    private final static String TEST_MESSAGE = "This is test..";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seanTool = SeanTool.getInstance(this);

        setSeanRecyclerView();
    }

    private void setSeanRecyclerView() {

        SeanRecyclerView seanRecyclerView = (SeanRecyclerView) findViewById(R.id.srvTest);
        seanRecyclerView.setSeanRecyclerViewBuilder(new SeanRecyclerView.SeanRecyclerViewBuilder() {

            List<MockDataInfo> mockDataInfos = new MockData().getMockDataInfos();

            @Override
            public int getCellCount() {
                return mockDataInfos.size();
            }

            @Override
            public SeanRecyclerViewCell onCreateCell(ViewGroup viewGroup, int type) {
                return new RecyclerViewCell(getApplicationContext(), R.layout.cell_mock);
            }

            @Override
            public void onBindData(SeanRecyclerViewCell recyclerViewCell, int position) {
                MockDataInfo mockDataInfo = mockDataInfos.get(position);
                RecyclerViewCell cell = (RecyclerViewCell) recyclerViewCell;
                cell.bindData(mockDataInfo);
            }
        });
        seanRecyclerView.onBuild();

    }

    @Override
    public void onClick(View view) {
        seanTool.getNotifyTool().sentSimpleNotification(TEST_TITLE, TEST_MESSAGE);
    }


}
