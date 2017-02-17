package com.example.administrator.giftsaying.presenter;

import com.example.administrator.giftsaying.model.bean.HorizontalBean;

/**
 *
 * Created by Administrator on 2017/2/12.
 */

public interface IHorizontalPresenter {
    void getHorizontalResult();
    interface SendHorizontalResult{
        void sendHorizontalReasult(HorizontalBean bean);
    }
}
