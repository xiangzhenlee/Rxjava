package com.yushan.rxjava.engine;

import com.yushan.rxjava.UrlContanier;
import com.yushan.rxjava.api.HttpService;
import com.yushan.rxjava.utils.Config;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * http封装库，作为引擎提供okhttp、rxjava与retrofit的封装
 * <p/>
 * Created by yushan on 2016/8/4.
 */
public class HttpEngine {
    private static final int DEFAULT_TIMEOUT = 5;
    private Retrofit retrofit;
    private final String BASE_URL = UrlContanier.mobile_base;
    private HttpService apiService;
    private HttpEngine httpEngine = null;

    private static class SingletonHolder {
        private static HttpEngine INSTANCE = new HttpEngine();
    }

    public static HttpEngine getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static void getNewInstance() {
        SingletonHolder.INSTANCE = new HttpEngine();
    }

    public HttpService getHttpService() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.addInterceptor(logging);
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("clientVersion", Config.CLIENTVERSION)
                                .addHeader("clientName", Config.CLIENTNAME)
                                .addHeader("accessToken", Config.ACCESSTOKEN)
                                .addHeader("version", Config.HTTP_VERSION)
                                .build();
                        return chain.proceed(request);
                    }

                }).build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        apiService = retrofit.create(HttpService.class);
        return apiService;
    }


}
