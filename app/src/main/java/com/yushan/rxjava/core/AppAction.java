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

import com.yushan.rxjava.model.LoginRequest;
import com.yushan.rxjava.model.LoginResponse;
import com.yushan.rxjava.model.UserInfoResponse;

import rx.Subscriber;


/**
 * 接收app层的各种业务逻辑
 *
 * @author yushan
 */
public interface AppAction {
    /**
     * 登录模块
     *
     * @param listener  回调监听器
     */
    void login(LoginRequest loginRequest, Subscriber<LoginResponse> listener);

    /**
     * 获取个人基本信息
     *
     * @param subscriber
     */
    void getUserInfo(Subscriber<UserInfoResponse> subscriber);


}
