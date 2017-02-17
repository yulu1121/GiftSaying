package com.example.administrator.giftsaying.model;

import android.content.Context;

import com.example.administrator.giftsaying.model.bean.HorizontalBean;

/**
 *
 * Created by Administrator on 2017/2/12.
 */

public interface IHorizontalModel {
    void getHorizontalData(Context context,SendHorizontalData data);
    interface SendHorizontalData{
        void sendHorizontalData(HorizontalBean bean);
    }
}
