package com.example.administrator.giftsaying.model.impl;

import android.content.Context;

import com.example.administrator.giftsaying.model.IHomeModel;
import com.example.administrator.giftsaying.model.bean.BannerBean;
import com.example.administrator.giftsaying.model.bean.ChoiceBean;
import com.example.administrator.giftsaying.utils.AppHttpService;
import com.example.administrator.giftsaying.utils.InitApplication;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 获取数据
 * Created by Administrator on 2017/2/7.
 */

public class HomeModel implements IHomeModel {
    @Override
    public void getChoiceData(Context context,final SendChoiceData data,int channel) {
        InitApplication application= (InitApplication) context.getApplicationContext();
        AppHttpService httpService = application.getRetrofit().create(AppHttpService.class);
        httpService.getChoiceBean(channel,2,1,2,20,0)
                    .map(new Func1<ChoiceBean, ChoiceBean>() {
                        @Override
                        public ChoiceBean call(ChoiceBean bean) {
                            return bean;
                        }
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<ChoiceBean>() {
                                   @Override
                                   public void call(ChoiceBean bean) {
                                       data.sendChoiceData(bean);
                                   }
                               }, new Action1<Throwable>() {
                                   @Override
                                   public void call(Throwable throwable) {
                                        throwable.printStackTrace();
                                   }
                               },
                            new Action0() {
                                @Override
                                public void call() {

                                }
                            });
//        OkHttpTools.builder().url(UrlConstants.CHOICE_URL)
//                .get().callback(new OkHttpTools.OkCallBack() {
//            @Override
//            public void success(String result) {
//                Gson gson = new Gson();
//                ChoiceBean choiceBean = gson.fromJson(result, ChoiceBean.class);
//                data.sendChoiceData(choiceBean);
//            }
//        });
    }
    @Override
    public void getBannerData(Context context,final SendChoiceData data) {
        InitApplication application= (InitApplication) context.getApplicationContext();
        AppHttpService httpService = application.getRetrofit().create(AppHttpService.class);
        httpService.getBannerBean()
                    .map(new Func1<BannerBean, BannerBean>() {
                        @Override
                        public BannerBean call(BannerBean bannerBean) {
                            return bannerBean;
                        }
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<BannerBean>() {
                        @Override
                        public void call(BannerBean bannerBean) {
                            data.sendBannerData(bannerBean);
                        }
                    });
//        OkHttpTools.builder().url(UrlConstants.BANNER_URL)
//                .get().callback(new OkHttpTools.OkCallBack() {
//            @Override
//            public void success(String result) {
//                Gson gson = new Gson();
//                BannerBean bannerBean = gson.fromJson(result, BannerBean.class);
//                data.sendBannerData(bannerBean);
//            }
//        });
    }
}
