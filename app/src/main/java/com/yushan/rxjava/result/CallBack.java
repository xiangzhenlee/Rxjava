package com.yushan.rxjava.result;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;


import com.yushan.rxjava.utils.ToastUtil;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.HashMap;

import rx.Subscriber;

/**
 * Created by yushan on 2016/7/28.
 */
public class CallBack<T> extends Subscriber<T> {
    private static final String TAG = "http:CallBack";
    public static final String TOKEN_OUTDATE = "1003";
    private Context context;
    private Handler handler = new Handler();
    private SharedPreferences sharedPreferencesUser;

    public CallBack(Context context) {
        this.context = context;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof SocketTimeoutException) {
            ToastUtil.showCenter(context, "网络不给力，请稍候重试…");
        } else if (e instanceof ConnectException) {
            ToastUtil.showCenter(context, "网络不可用");
        } else if (e instanceof java.lang.NullPointerException) {
        }
    }

    @Override
    public void onNext(T t) {

    }


}
