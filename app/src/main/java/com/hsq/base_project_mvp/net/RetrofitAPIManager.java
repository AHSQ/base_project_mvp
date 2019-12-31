package com.hsq.base_project_mvp.net;

import android.util.Log;

import com.hsq.base_project_mvp.BuildConfig;
import com.hsq.base_project_mvp.Constant;
import com.hsq.base_project_mvp.MyApplication;
import com.hsq.base_project_mvp.utils.SPUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAPIManager {

    public static RequestApi provideClientApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(genericClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(RequestApi.class);
    }
    public static RequestApi provideClientApi(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(genericClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(RequestApi.class);
    }

    public static OkHttpClient genericClient() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger()        {
            @Override
            public void log(String message){
                if (BuildConfig.DEBUG) Log.d("Http", message+"");
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Authorization", "Bearer "+ SPUtils.get(MyApplication.getContext(),"token",""))
                                .build();
                        return chain.proceed(request);
                    }
                })
                .addInterceptor(loggingInterceptor)
                .build();
        return httpClient;
    }
}
