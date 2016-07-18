package com.sean.nanastudio.seanutilsample;

import java.util.ArrayList;
import java.util.List;

/**
 * SeanUtilSample
 * Created by Sean on 2016/7/18上午10:44.
 */
public class MockData {

    List<MockDataInfo> mockDataInfos;

    public List<MockDataInfo> getMockDataInfos() {
        return getTempMockDataInfos();
    }

    private List<MockDataInfo> getTempMockDataInfos() {
        List<MockDataInfo> mockDataInfos = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            mockDataInfos.add(new MockDataInfo(i));
        }
        return mockDataInfos;
    }

}
