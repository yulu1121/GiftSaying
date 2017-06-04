package com.example.administrator.giftsaying.utils;

import com.example.administrator.giftsaying.constants.UrlConstants;
import com.example.administrator.giftsaying.model.bean.BannerBean;
import com.example.administrator.giftsaying.model.bean.ChoiceBean;
import com.example.administrator.giftsaying.model.bean.HorizontalBean;
import com.example.administrator.giftsaying.model.bean.HotBean;
import com.example.administrator.giftsaying.model.bean.TopCategoryBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 *
 * Created by Administrator on 2017/2/9.
 */

public interface AppHttpService {
    @GET(UrlConstants.CATEGORY_URL_TWO)
    Observable<TopCategoryBean> getTopCategoryBean();
    @GET("v2/channels/{num}/items")
    Observable<ChoiceBean> getChoiceBean(@Path("num")int num,
                                         @Query("ad") int ad,
                                         @Query("gender")int gender,
                                         @Query("generation") int generation,
                                         @Query("limit") int limit,
                                         @Query("offset") int offset);
    @GET(UrlConstants.BANNER_URL_TWO)
    Observable<BannerBean> getBannerBean();
    @GET(UrlConstants.HORIZONTAL_URL)
    Observable<HorizontalBean> getHorizontalBean();
    @GET(UrlConstants.HOT_URL)
    Observable<HotBean> getHotBean();
}
