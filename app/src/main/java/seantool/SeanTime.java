
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
