package com.example.administrator.giftsaying.utils;

import com.example.administrator.giftsaying.constants.UrlConstants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * Created by Administrator on 2017/2/10.
 */

public class RetrofitUtils {
    public AppHttpService  getHttpService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlConstants.COMMON_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        AppHttpService httpService = retrofit.create(AppHttpService.class);
        return httpService;
    }
}
