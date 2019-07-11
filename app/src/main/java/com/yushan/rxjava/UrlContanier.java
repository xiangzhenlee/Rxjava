package com.yushan.rxjava;

/**
 * 服务器接口地址
 * <p/>
 * Created by yushan on 2016/7/21.
 */
public interface UrlContanier {
    /**
     * 现网环境接口地址
     */
    public static final String upload_base = "http://sync.wanbu.com.cn/";
    public static final String mobile_base = "https://mobile.wanbu.com.cn/";
    public static final String php_base = "https://wap.wanbu.com.cn/";


    /**
     * 登录、注册模块
     */
    public static final String GetUserLogin =upload_base + "phoneServer/Login_Reguser_Service/GetUserLogin";
    public static final String GetUserInfo =upload_base + "phoneServer/Login_Reguser_Service/GetUserInfo";
    public static final String GetPedometerInfo = upload_base + "phoneServer/Login_Reguser_Service/GetPedometerInfo";
    public static final String Register =upload_base + "phoneServer/Login_Reguser_Service/Register";


    /**
     * 测试接口
     */
    public static final String isOpenFarm = php_base + "NewWanbu/App/Api/index.php/HealthFarm/isOpenFarm";

}
