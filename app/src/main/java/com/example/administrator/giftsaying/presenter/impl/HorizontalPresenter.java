package com.example.administrator.giftsaying.presenter.impl;

import android.content.Context;

import com.example.administrator.giftsaying.model.IHorizontalModel;
import com.example.administrator.giftsaying.model.bean.HorizontalBean;
import com.example.administrator.giftsaying.model.impl.HorizontalModel;
import com.example.administrator.giftsaying.presenter.IHorizontalPresenter;

/**
 *
 * Created by Administrator on 2017/2/12.
 */

public class HorizontalPresenter implements IHorizontalPresenter,IHorizontalModel.SendHorizontalData {
    private Context context;
    private IHorizontalModel model;
    SendHorizontalResult result;
    public HorizontalPresenter(Context context,SendHorizontalResult result){
        this.context = context;
        model = new HorizontalModel();
        this.result = result;
    }
    @Override
    public void getHorizontalResult() {
        model.getHorizontalData(context,this);
    }

    @Override
    public void sendHorizontalData(HorizontalBean bean) {
            result.sendHorizontalReasult(bean);
    }
}
