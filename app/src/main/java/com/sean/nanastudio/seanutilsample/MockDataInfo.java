package com.sean.nanastudio.seanutilsample;

import java.io.Serializable;

/**
 * SeanUtilSample
 * Created by Sean on 2016/7/18上午10:51.
 */
public class MockDataInfo implements Serializable {
    int serialID;

    public MockDataInfo(int serialID) {
        this.serialID = serialID;
    }

    public int getSerialID() {
        return serialID;
    }
}
