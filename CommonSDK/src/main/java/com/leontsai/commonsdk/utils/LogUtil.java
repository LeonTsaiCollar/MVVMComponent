package com.leontsai.commonsdk.utils;

import android.util.Log;

import com.leontsai.commonsdk.BuildConfig;

public final class LogUtil {

    private static final String TAG = "cyl";

    public static void d(String msg) {
        if (BuildConfig.DEBUG)
            Log.d(TAG, msg);
    }
}
