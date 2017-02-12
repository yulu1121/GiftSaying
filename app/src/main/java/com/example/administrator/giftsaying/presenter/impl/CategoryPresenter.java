package com.example.administrator.giftsaying.presenter.impl;

import android.content.Context;

import com.example.administrator.giftsaying.model.ICategoryModel;
import com.example.administrator.giftsaying.model.bean.TopCategoryBean;
import com.example.administrator.giftsaying.presenter.ICategoryPresenter;

import javax.inject.Inject;

/**
 *
 * Created by Administrator on 2017/2/8.
 */

public class CategoryPresenter implements ICategoryPresenter,ICategoryModel.SendCategoryData {
    private Context context;
    private ICategoryModel model;
    @Inject
    SendCategoryResult result;
    public CategoryPresenter(SendCategoryResult result, ICategoryModel model,Context context){
        this.result = result;
        this.model = model;
        this.context = context;
    }

    @Override
    public void getCategoryResult() {
        model.getCategoryData(context,this);
    }

    @Override
    public void sendCategoryData(TopCategoryBean bean) {
        result.sendCategoryResult(bean);
    }
}
