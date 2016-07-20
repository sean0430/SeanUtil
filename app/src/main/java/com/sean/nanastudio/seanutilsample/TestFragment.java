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

package com.sean.nanastudio.seanutilsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import seantool.recyclerview.SeanRecyclerView;
import seantool.recyclerview.SeanRecyclerViewCell;

/**
 * SeanUtilSample
 * Created by Sean on 2016/7/20上午11:30.
 */
public class TestFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        SeanRecyclerView srv = (SeanRecyclerView)inflater.inflate(
                R.layout.fragment_test,container,false);
        setSeanRecyclerView(srv);
        return srv;
    }

    private void setSeanRecyclerView(SeanRecyclerView seanRecyclerView) {


        seanRecyclerView.setSeanRecyclerViewBuilder(new SeanRecyclerView.SeanRecyclerViewBuilder() {

            List<MockDataInfo> mockDataInfos = new MockData().getMockDataInfos();

            @Override
            public int getCellCount() {
                return mockDataInfos.size();
            }

            @Override
            public SeanRecyclerViewCell onCreateCell(ViewGroup viewGroup, int type) {
                return new RecyclerViewCell(getContext(), R.layout.cell_mock);
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


}
