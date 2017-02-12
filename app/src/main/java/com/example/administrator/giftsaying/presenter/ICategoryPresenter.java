package com.example.administrator.giftsaying.presenter;

import com.example.administrator.giftsaying.model.bean.TopCategoryBean;

/**
 *
 * Created by Administrator on 2017/2/8.
 */

public interface ICategoryPresenter {
    void getCategoryResult();
    interface SendCategoryResult{
        void sendCategoryResult(TopCategoryBean bean);
    }
}
