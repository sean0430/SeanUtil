/*
 *  Copyright (C) 2016 by Sean Lin
 *
 *  ALL RIGHTS RESERVED
 *
 *
 */

package seantool;

import android.util.Log;

import java.text.DateFormat;
import java.util.Date;

/**
 * SeanUtilSample
 * Created by Sean on 2016/7/15上午11:46.
 */
@SuppressWarnings("unused")
public class SeanTime {

    private static final String TAG = "SeanTime";

    public String getCurrentTimeStamp() {
        Long tsLong = System.currentTimeMillis()/1000;
        return tsLong.toString();
    }

    public String getCurrentTime(int dateFormatAttribute) {
        DateFormat dateFormat = DateFormat.getDateInstance(dateFormatAttribute);
        return dateFormat.format(new Date());
    }




}
