package com.yushan.rxjava;

/**
 * 服务器接口地址
 * <p/>
 * Created by yushan on 2016/7/21.
 */
public interface UrlContanier {
    /**
     * 测试环境接口地址
     */
    public static final String upload_base = "http://192.168.20.245:80/";
    public static final String mobile_base = "http://192.168.20.85:8080/";
    public static final String php_base = "http://192.168.20.244/";


    /**
     * 登录、注册模块
     */
    public static final String GetUserLogin =upload_base + "phoneServer/Login_Reguser_Service/GetUserLogin";
    public static final String GetUserInfo =upload_base + "phoneServer/Login_Reguser_Service/GetUserInfo";
    public static final String GetPedometerInfo = upload_base + "phoneServer/Login_Reguser_Service/GetPedometerInfo";
    public static final String Register =upload_base + "phoneServer/Login_Reguser_Service/Register";

}
