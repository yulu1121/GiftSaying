package com.example.administrator.giftsaying.presenter.impl;

import android.content.Context;

import com.example.administrator.giftsaying.model.IHomeModel;
import com.example.administrator.giftsaying.model.bean.BannerBean;
import com.example.administrator.giftsaying.model.bean.ChoiceBean;
import com.example.administrator.giftsaying.presenter.IHomePresenter;

import javax.inject.Inject;

/**
 *
 * Created by Administrator on 2017/2/7.
 */

public class HomePresenter implements IHomePresenter,IHomeModel.SendChoiceData{
    private Context context;
    private IHomeModel model;
    @Inject
    SendChoiceResult result;
    public HomePresenter(SendChoiceResult result,IHomeModel model,Context context){
        this.result = result;
        this.model = model;
        this.context = context;
    }
    @Override
    public void getChoiceBeanResult() {
        model.getChoiceData(context,this);
    }

    @Override
    public void getBannerBeanResultl() {
        model.getBannerData(context,this);
    }

    @Override
    public void sendChoiceData(ChoiceBean choiceBean) {
        result.sendChoiceBeanResult(choiceBean);
    }

    @Override
    public void sendBannerData(BannerBean bannerBean) {
        result.sendBannerBeanResult(bannerBean);
    }
}


