package com.yushan.rxjava;


import android.content.Context;
import android.os.Bundle;
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

import com.yushan.rxjava.core.AppAction;
import com.yushan.rxjava.core.AppActionImpl;
import com.yushan.rxjava.engine.HttpEngine;
import com.yushan.rxjava.model.LoginRequest;
import com.yushan.rxjava.model.LoginResponse;
import com.yushan.rxjava.result.CallBack;
import com.yushan.rxjava.utils.PreferenceHelper;
import com.yushan.rxjava.utils.TextUtil;
import com.yushan.rxjava.utils.ToastUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_login;
    private Button btn_quit;
    private ImageView id_del_username;
    private EditText etUsername;
    private EditText etPassword;
    private ImageView id_del_password;
    private AppAction appAction;
    private TextView tv_show;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        //初始化core层
        appAction = new AppActionImpl(getApplicationContext());


        initView();
    }

    private void initView() {
        etUsername = (EditText)findViewById(R.id.et_username);
        etPassword = (EditText)findViewById(R.id.et_password);
        btn_login = (Button)findViewById(R.id.btn_login);
        btn_quit = (Button)findViewById(R.id.btn_quit);
        id_del_username = (ImageView)findViewById(R.id.id_del_username);
        id_del_password = (ImageView)findViewById(R.id.id_del_password);
        btn_login.setOnClickListener(this);
        btn_quit.setOnClickListener(this);
        tv_show = (TextView)findViewById(R.id.tv_show);

        etUsername.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                Log.i("FF", "---etUsername----hasFocus-");
                if (hasFocus
                        && etUsername.getText().toString().trim().length() > 0) {
                    id_del_username.setVisibility(View.VISIBLE);
                    id_del_username.setClickable(true);

                } else {
                    id_del_username.setVisibility(View.INVISIBLE);
                    id_del_username.setClickable(false);
                }
            }

        });

        etUsername.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                int len = s.length();
                if (len > 0) {
                    id_del_username.setVisibility(View.VISIBLE);
                    id_del_username.setClickable(true);
                } else {
                    id_del_username.setVisibility(View.INVISIBLE);
                    id_del_username.setClickable(false);
                }

            }

        });

        id_del_username.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                etUsername.setHint(TextUtil.hintSet("请输入帐号")); // 一定要进行转换,否则属性会消失
                etUsername.setText("");
            }
        });

        etUsername.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {

                    if ("".equals(etUsername.getText().toString())
                            || etUsername.getText().toString() == null) {
                        // txtPass.setFocusable(true);
                        return true;
                    } else {
                        // do nothing
                        etPassword.setFocusable(true);
                    }

                }
                return false;
            }

        });


        etPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    newLogin();
                }
                return false;
            }
        });

        etPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus
                        && etPassword.getText().toString().trim().length() > 0) {
                    id_del_password.setVisibility(View.VISIBLE);
                    id_del_password.setClickable(true);
                } else {
                    id_del_password.setVisibility(View.INVISIBLE);
                    id_del_password.setClickable(false);
                }
            }

        });
        etPassword.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                int len = s.length();
                if (len > 0) {
                    id_del_password.setVisibility(View.VISIBLE);
                    id_del_password.setClickable(true);
                } else {
                    id_del_password.setVisibility(View.INVISIBLE);
                    id_del_password.setClickable(false);
                }

            }

        });

        id_del_password.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                etPassword.setHint(TextUtil.hintSet("请输入密码"));
                etPassword.setText("");
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_login:
                newLogin();
                break;
            case R.id.btn_quit:
                break;
            default:
                break;
        }
    }

    private void newLogin() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setAuthName(com.yushan.rxjava.utils.Config.AUTHNAME);
        loginRequest.setAuthPassword(com.yushan.rxjava.utils.Config.AUTHPASSWORD);
        loginRequest.setUsername(etUsername.getText().toString().trim());
        loginRequest.setPassword(etPassword.getText().toString().trim());
        loginRequest.setPhonebrand(android.os.Build.BRAND);
        loginRequest.setPhonemodel(android.os.Build.MODEL);

        this.appAction.login(loginRequest, new CallBack<LoginResponse>(getApplicationContext()) {
            @Override
            public void onCompleted() {
                ToastUtil.showCenter(context ,"火星一号已经登陆成功");
                Log.e("lixz","onCompleted");

            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                ToastUtil.showCenter(context ,"火星一号已经炸毁");
                Log.e("lixz","onError");
            }

            @Override
            public void onStart() {
                ToastUtil.showCenter(context ,"火星一号已经起飞");
                Log.e("lixz","onStart");
            }

            @Override
            public void onNext(LoginResponse response) {
                ToastUtil.showCenter(context ,"火星一号正在着路");
                Log.e("lixz","onNext");
                tv_show.setText("" + response);
            }
        });
    }


}
