package com.example.administrator.giftsaying.model.impl;

import android.content.Context;

import com.example.administrator.giftsaying.model.ICategoryModel;
import com.example.administrator.giftsaying.model.bean.TopCategoryBean;
import com.example.administrator.giftsaying.utils.AppHttpService;
import com.example.administrator.giftsaying.utils.InitApplication;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 *
 * Created by Administrator on 2017/2/8.
 */

public class CategoryModel implements ICategoryModel {

    @Override
    public void getCategoryData(Context context, final SendCategoryData data) {
        //RetrofitUtils utils = new RetrofitUtils();
        InitApplication applicationInfo = (InitApplication) context.getApplicationContext();
        AppHttpService httpService  = applicationInfo.getRetrofit().create(AppHttpService.class);
        httpService.getTopCategoryBean()
                .map(new Func1<TopCategoryBean, TopCategoryBean>() {
                    @Override
                    public TopCategoryBean call(TopCategoryBean bean) {
                        return bean;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<TopCategoryBean>() {
                    @Override
                    public void call(TopCategoryBean bean) {
                        data.sendCategoryData(bean);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }, new Action0() {
                    @Override
                    public void call() {

                    }
                });

//        OkHttpTools.builder().url(UrlConstants.CATEGORY_URL)
//                .get().callback(new OkHttpTools.OkCallBack() {
//            @Override
//            public void success(String result) {
//                Gson gson = new Gson();
//                TopCategoryBean bean = gson.fromJson(result, TopCategoryBean.class);
//                data.sendCategoryData(bean);
//            }
//        });
    }
}

