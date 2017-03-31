package com.yushan.rxjava.result;

import android.util.Log;

/**
 * 用于定义一些网络回调的error信息
 *
 * Created by yushan on 2016/6/22.
 */
public class ApiException extends RuntimeException {
    private static final String TAG = "http:ApiException";

    public ApiException(String resultCode, String resultMsg) {
        super(getApiExceptionMessage(resultCode, resultMsg));
    }

    private static String getApiExceptionMessage(String resultCode, String resultMsg) {
        Log.v(TAG, "resultCode:" + resultCode);
        return resultMsg+"#"+resultCode;
    }
}
