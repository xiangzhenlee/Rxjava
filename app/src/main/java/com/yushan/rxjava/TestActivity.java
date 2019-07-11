package com.yushan.rxjava;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.yushan.rxjava.api.Api;
import com.yushan.rxjava.api.ApiImpl;
import com.yushan.rxjava.model.CheckIsOpenFarmResponse;
import com.yushan.rxjava.model.LoginRequest;
import com.yushan.rxjava.model.LoginResponse;
import com.yushan.rxjava.result.CallBack;
import com.yushan.rxjava.utils.Config;
import com.yushan.rxjava.utils.TextUtil;
import com.yushan.rxjava.utils.ToastUtil;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_su;
    private Button btn_hui;
    private ImageView id_del_username;
    private ImageView id_del_password;
    private TextView tv_show;
    private Context context;
    private TextView tv_token;
    private TextView tv_userid;
    private String checkIsOpenFarm;

    private CheckIsOpenFarmResponse checkIsOpenFarm_j;
    private boolean isError;
    private String ip;
    private static String server_ip = "";
    private int times;
    private int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        initView();

        newLogin();
    }

    private void initView() {

        tv_userid = (TextView) findViewById(R.id.tv_userid);
        tv_token = (TextView) findViewById(R.id.tv_token);
        btn_su = (Button) findViewById(R.id.btn_su);
        btn_hui = (Button) findViewById(R.id.btn_hui);
        id_del_username = (ImageView) findViewById(R.id.id_del_username);
        id_del_password = (ImageView) findViewById(R.id.id_del_password);
        btn_su.setOnClickListener(this);
        btn_hui.setOnClickListener(this);
        tv_show = (TextView) findViewById(R.id.tv_show);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_su:
                times = 10;
                request();
                break;
            case R.id.btn_hui:
                times = 50;
                request();
                break;
            default:
                break;
        }
    }

    private void request() {
        final Handler mHandler = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                //do something //每隔1s循环执行run方法
                if (time >= times) {
                    time = 0;
                    return;
                }
                if (!isError) {
                    Log.e("yushan", "请求次数:" + time);
                    ip = getServerIp();
                    checkIsOpenFarm();
                } else {
                    isError = false;
                    time = 0;
                    return;
                }

                mHandler.postDelayed(this, 1000);
            }
        }; //主线程中调用：
        mHandler.postDelayed(r, 100);//延时100毫秒

    }

    private void newLogin() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setAuthName(Config.AUTHNAME);
        loginRequest.setAuthPassword(Config.AUTHPASSWORD);
        loginRequest.setUsername("yushan_lee");
        loginRequest.setPassword("737576");
        loginRequest.setPhonebrand(android.os.Build.BRAND);
        loginRequest.setPhonemodel(android.os.Build.MODEL);
        Api mRequest = new ApiImpl();

        mRequest.login(new CallBack<LoginResponse>(getApplicationContext()) {
            @Override
            public void onCompleted() {
                tv_userid.setText("userId:705445");
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }

            @Override
            public void onNext(LoginResponse response) {
                tv_token.setText("token:" + response.getAccessToken());
                Config.ACCESSTOKEN = response.getAccessToken();
            }
        }, loginRequest);
    }

    private void checkIsOpenFarm() {
        Map<String, Object> request = getBasePhpRequest(this);
        Api mRequest = new ApiImpl();
        mRequest.checkIsOpenFarm(new CallBack<CheckIsOpenFarmResponse>(this) {

            @Override
            public void onCompleted() {
                time++;
                tv_show.setText("(" + time + "):IP:" + ip + ":返回::" + checkIsOpenFarm);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                isError = true;
                time++;
                tv_show.setText("(" + time + "):IP:" + ip + ":错误::" + e);
            }

            @Override
            public void onNext(CheckIsOpenFarmResponse checkIsOpenFarmResponse) {
                checkIsOpenFarm = checkIsOpenFarmResponse.toString();
            }
        }, request);
    }

    public static Map<String, Object> getBasePhpRequest(Context context) {

        Map<String, Object> request = new HashMap<>();
        request.put("userid", 705445);
        request.put("accessToken", Config.ACCESSTOKEN);
        request.put("clientVersion", Config.CLIENTVERSION);
        request.put("clientName", Config.CLIENTNAME);
        request.put("version", Config.HTTP_VERSION);

        return request;
    }

    /**
     * 获取服务器IP地址
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public static String getServerIp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    InetAddress address = InetAddress.getByName("wap.wanbu.com.cn");//获取的是该网站的ip地址
                    server_ip = address.getHostAddress();

                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        return server_ip;
    }

}
