package com.yushan.rxjava.api;

import android.content.Context;

import com.yushan.rxjava.engine.HttpEngine;
import com.yushan.rxjava.model.LoginRequest;
import com.yushan.rxjava.model.LoginResponse;
import com.yushan.rxjava.model.UserInfoResponse;
import com.yushan.rxjava.result.HttpResultFunc;
import com.yushan.rxjava.utils.JsonUtil;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by yushan on 2016/6/22.
 */
public class ApiImpl implements Api {
    private static final String TAG = "http:ApiImpl";
    private HttpService httpService = null;

    public ApiImpl() {
        httpService = HttpEngine.getInstance().getHttpService();
    }

    @Override
    public void login(Subscriber<LoginResponse> subscriber, LoginRequest loginRequest) {
        String json = JsonUtil.GsonString(loginRequest);
        httpService.login(json)
                .flatMap(new HttpResultFunc<LoginResponse>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void getUserInfo(Subscriber<UserInfoResponse> subscriber) {
        httpService.getUserInfo()
                .flatMap(new HttpResultFunc<UserInfoResponse>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


}
