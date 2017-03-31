package com.yushan.rxjava.result;

import rx.Observable;
import rx.functions.Func1;

/**
 * 根据服务器的返回码判断，非“0000”，代表访问出错，抛出异常。
 *
 * Created by yushan on 2016/7/7.
 */
public class HttpResultFunc<T> implements Func1<HttpResult<T>, Observable<T>> {
    //成功返回码
    public static final String SUCCESS = "0000";

    @Override
    public Observable<T> call(HttpResult<T> tHttpResult) {
        if(!tHttpResult.getResultCode().equals(SUCCESS)){
            throw new ApiException(tHttpResult.getResultCode(), tHttpResult.getRespMsg());
        }
        return Observable.from(tHttpResult.getData());
    }
}
