package com.example.administrator.giftsaying.model;

import android.content.Context;

import com.example.administrator.giftsaying.model.bean.TopCategoryBean;

/**
 *
 * Created by Administrator on 2017/2/8.
 */

public interface ICategoryModel {
    /**
     * 获取分类数据的方法
     * added by yulu 2017.02.07
     */
    void getCategoryData(Context context,SendCategoryData data);
    interface SendCategoryData{
        /**
         * 向presenter传送TopCategoryBean数据的方法
         * added by yulu 2017.02.07
         */
        void sendCategoryData(TopCategoryBean bean);
    }

}
