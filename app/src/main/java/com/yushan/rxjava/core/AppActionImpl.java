/**
 * Copyright (C) 2015. Keegan小钢（http://keeganlee.me）
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yushan.rxjava.core;

import android.content.Context;
import android.text.TextUtils;

import com.yushan.rxjava.api.Api;
import com.yushan.rxjava.api.ApiImpl;
import com.yushan.rxjava.model.LoginRequest;
import com.yushan.rxjava.model.LoginResponse;
import com.yushan.rxjava.model.UserInfoResponse;

import rx.Subscriber;

/**
 * AppAction接口的实现类
 *
 * @author yushan
 */
public class AppActionImpl implements AppAction {
    private Context context;
    private final static int LOGIN_OS = 1; // 表示Android
    private Api api;

    public AppActionImpl(Context context) {
        this.context = context;
        api = new ApiImpl();
    }

    @Override
    public void login(final LoginRequest loginRequest, final  Subscriber<LoginResponse> subscriber) {
        // 参数检查
        final String loginName = loginRequest.getUsername();
        final String password = loginRequest.getPassword();
        if (TextUtils.isEmpty(loginName)) {
            if (subscriber != null) {
                subscriber.onError(new Exception(ErrorEvent.USERNAME_NULL));
            }
            return;
        }
        if (TextUtils.isEmpty(password)) {
            if (subscriber != null) {
                subscriber.onError(new Exception(ErrorEvent.PASSWORD_ILLEGAL));
            }
            return;
        }
        api.login(subscriber, loginRequest);
    }

    @Override
    public void getUserInfo(Subscriber<UserInfoResponse> subscriber) {
        api.getUserInfo(subscriber);
    }

}
