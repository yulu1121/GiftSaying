package com.example.administrator.giftsaying.presenter;

import com.example.administrator.giftsaying.model.bean.BannerBean;
import com.example.administrator.giftsaying.model.bean.ChoiceBean;

/**
 * 向View层传递数据的presenter层
 * Created by Administrator on 2017/2/7.
 */

public interface IHomePresenter {

    /**
     * 从Model层获取数据的方法
     * added by yulu 2017.02.07
     */
    void getChoiceBeanResult();
    void getBannerBeanResultl();
    /**
     * 向View层传送数据的方法
     * added by yulu 2017.02.07
     */
    interface SendChoiceResult{
        void sendChoiceBeanResult(ChoiceBean bean);
        void sendBannerBeanResult(BannerBean bannerBean);
    }
}
