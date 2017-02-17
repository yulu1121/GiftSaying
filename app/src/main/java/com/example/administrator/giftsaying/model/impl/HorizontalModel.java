package com.example.administrator.giftsaying.model.impl;

import android.content.Context;

import com.example.administrator.giftsaying.model.IHorizontalModel;
import com.example.administrator.giftsaying.model.bean.HorizontalBean;
import com.example.administrator.giftsaying.utils.AppHttpService;
import com.example.administrator.giftsaying.utils.InitApplication;

import retrofit2.Retrofit;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 *
 * Created by Administrator on 2017/2/12.
 */

public class HorizontalModel implements IHorizontalModel {
    @Override
    public void getHorizontalData(Context context, final SendHorizontalData data) {
        InitApplication application = (InitApplication) context.getApplicationContext();
        Retrofit retrofit = application.getRetrofit();
        AppHttpService appHttpService = retrofit.create(AppHttpService.class);
        appHttpService.getHorizontalBean()
                .map(new Func1<HorizontalBean, HorizontalBean>() {
                    @Override
                    public HorizontalBean call(HorizontalBean horizontalBean) {
                        return horizontalBean;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HorizontalBean>() {
                    @Override
                    public void call(HorizontalBean horizontalBean) {
                        data.sendHorizontalData(horizontalBean);
                    }
                });

    }
}
