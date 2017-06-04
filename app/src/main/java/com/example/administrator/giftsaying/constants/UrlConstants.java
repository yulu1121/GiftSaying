package com.example.administrator.giftsaying.constants;

/**
 *
 * Created by Administrator on 2017/2/7.
 */

public class UrlConstants {
    public static final String COMMON_URL = "http://api.liwushuo.com/";
    public static final String CATEGORY_URL_TWO= "v2/channels/preset?gender=1&generation=2";
    public static final String CHOICE_URL = COMMON_URL+"v2/channels/101/items?gender=1&limit=20&offset=0&generation=2";
    public static final String BANNER_URL = COMMON_URL+"/v2/banners";
    public static final String BANNER_URL_TWO = "/v2/banners";
    public static final String HORIZONTAL_URL = "v2/secondary_banners?gender=1&generation=1";
    public static final String HOT_URL = "v2/items?gender=1&limit=20&offset=0&generation=2";
}
