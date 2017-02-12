package com.example.administrator.giftsaying.model;

import android.content.Context;

import com.example.administrator.giftsaying.model.bean.BannerBean;
import com.example.administrator.giftsaying.model.bean.ChoiceBean;

/**
 *  获取类别数据的Model层
 * Created by Administrator on 2017/2/7.
 */

public interface IHomeModel {
    /**
     *获取精选的数据
     */
    void getChoiceData(Context context,SendChoiceData data);
    void getBannerData(Context context,SendChoiceData data);
    /**
     * 向prsenter传送数据的接口
     * added by yulu 2017.02.07
     */
    interface SendChoiceData{
        /**
         * 向presenter传送ChoiceBean数据的方法
         * @param choiceBean
         * added by yulu 2017.02.08
         */
        void sendChoiceData(ChoiceBean choiceBean);
        void sendBannerData(BannerBean bannerBean);
    }
}
