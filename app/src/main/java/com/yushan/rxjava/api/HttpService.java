package com.yushan.rxjava.api;


import com.yushan.rxjava.UrlContanier;
import com.yushan.rxjava.model.CheckIsOpenFarmResponse;
import com.yushan.rxjava.model.LoginResponse;
import com.yushan.rxjava.model.UserInfoResponse;
import com.yushan.rxjava.result.HttpResult;

import java.util.Map;

import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by yushan on 2016/6/22.
 */
public interface HttpService {

    /**
     * 登录
     *
     * @param reqMessageBody 登录需要的参数
     * @return
     */
    @FormUrlEncoded
    @POST(UrlContanier.GetUserLogin)
    Observable<HttpResult<LoginResponse>> login(@Field("ReqMessageBody") String reqMessageBody);

    /**
     * 获取个人基本信息接口
     *
     * @param
     * @return
     */
    @GET(UrlContanier.GetUserInfo)
    Observable<HttpResult<UserInfoResponse>> getUserInfo();

    /**
     * 检测是否打开健康农场
     * @return
     */
    @FormUrlEncoded
    @POST(UrlContanier.isOpenFarm)
    Observable<HttpResult<CheckIsOpenFarmResponse>> checkIsOpenFarm(@FieldMap Map<String, Object> request);
}
