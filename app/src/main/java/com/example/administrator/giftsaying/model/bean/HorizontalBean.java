package com.example.administrator.giftsaying.model.bean;

import java.util.List;

/**
 *
 * Created by Administrator on 2017/2/12.
 */

public class HorizontalBean {

    /**
     * code : 200
     * data : {"background_webp_url":null,"secondary_banners":[{"ad_monitors":[],"id":76,"image_url":"http://img03.liwushuo.com/image/170112/67s4rsne4.jpg-w720","target_url":"liwushuo:///page?type=dailylucky","webp_url":"http://img03.liwushuo.com/image/170112/67s4rsne4.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"id":83,"image_url":"http://img01.liwushuo.com/image/170112/7k8erhmxu.jpg-w720","target_url":"liwushuo:///page?type=shop_collection&id=28","webp_url":"http://img01.liwushuo.com/image/170112/7k8erhmxu.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"id":88,"image_url":"http://img01.liwushuo.com/image/170209/rec4ljrii.jpg-w720","target_url":"liwushuo:///page?type=shop_collection&id=37","webp_url":"http://img01.liwushuo.com/image/170209/rec4ljrii.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"id":86,"image_url":"http://img01.liwushuo.com/image/170124/rj6jckktz.jpg-w720","target_url":"liwushuo:///page?type=url&url=https%3A%2F%2Fevent.liwushuo.com%2Fevent%2F170124-valentines-day%2Findex.html%23","webp_url":"http://img01.liwushuo.com/image/170124/rj6jckktz.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"id":81,"image_url":"http://img02.liwushuo.com/image/170112/3ba5gkpcw.jpg-w720","target_url":"liwushuo:///page?type=topic&topic_id=389","webp_url":"http://img02.liwushuo.com/image/170112/3ba5gkpcw.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"id":87,"image_url":"http://img03.liwushuo.com/image/170209/4vllhb1m0.jpg-w720","target_url":"liwushuo:///page?type=shop_collection&id=42","webp_url":"http://img03.liwushuo.com/image/170209/4vllhb1m0.jpg?imageView2/2/w/720/q/85/format/webp"}]}
     * message : OK
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * background_webp_url : null
         * secondary_banners : [{"ad_monitors":[],"id":76,"image_url":"http://img03.liwushuo.com/image/170112/67s4rsne4.jpg-w720","target_url":"liwushuo:///page?type=dailylucky","webp_url":"http://img03.liwushuo.com/image/170112/67s4rsne4.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"id":83,"image_url":"http://img01.liwushuo.com/image/170112/7k8erhmxu.jpg-w720","target_url":"liwushuo:///page?type=shop_collection&id=28","webp_url":"http://img01.liwushuo.com/image/170112/7k8erhmxu.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"id":88,"image_url":"http://img01.liwushuo.com/image/170209/rec4ljrii.jpg-w720","target_url":"liwushuo:///page?type=shop_collection&id=37","webp_url":"http://img01.liwushuo.com/image/170209/rec4ljrii.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"id":86,"image_url":"http://img01.liwushuo.com/image/170124/rj6jckktz.jpg-w720","target_url":"liwushuo:///page?type=url&url=https%3A%2F%2Fevent.liwushuo.com%2Fevent%2F170124-valentines-day%2Findex.html%23","webp_url":"http://img01.liwushuo.com/image/170124/rj6jckktz.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"id":81,"image_url":"http://img02.liwushuo.com/image/170112/3ba5gkpcw.jpg-w720","target_url":"liwushuo:///page?type=topic&topic_id=389","webp_url":"http://img02.liwushuo.com/image/170112/3ba5gkpcw.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"id":87,"image_url":"http://img03.liwushuo.com/image/170209/4vllhb1m0.jpg-w720","target_url":"liwushuo:///page?type=shop_collection&id=42","webp_url":"http://img03.liwushuo.com/image/170209/4vllhb1m0.jpg?imageView2/2/w/720/q/85/format/webp"}]
         */

        private Object background_webp_url;
        private List<SecondaryBannersBean> secondary_banners;

        public Object getBackground_webp_url() {
            return background_webp_url;
        }

        public void setBackground_webp_url(Object background_webp_url) {
            this.background_webp_url = background_webp_url;
        }

        public List<SecondaryBannersBean> getSecondary_banners() {
            return secondary_banners;
        }

        public void setSecondary_banners(List<SecondaryBannersBean> secondary_banners) {
            this.secondary_banners = secondary_banners;
        }

        public static class SecondaryBannersBean {
            /**
             * ad_monitors : []
             * id : 76
             * image_url : http://img03.liwushuo.com/image/170112/67s4rsne4.jpg-w720
             * target_url : liwushuo:///page?type=dailylucky
             * webp_url : http://img03.liwushuo.com/image/170112/67s4rsne4.jpg?imageView2/2/w/720/q/85/format/webp
             */

            private int id;
            private String image_url;
            private String target_url;
            private String webp_url;
            private List<?> ad_monitors;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public String getTarget_url() {
                return target_url;
            }

            public void setTarget_url(String target_url) {
                this.target_url = target_url;
            }

            public String getWebp_url() {
                return webp_url;
            }

            public void setWebp_url(String webp_url) {
                this.webp_url = webp_url;
            }

            public List<?> getAd_monitors() {
                return ad_monitors;
            }

            public void setAd_monitors(List<?> ad_monitors) {
                this.ad_monitors = ad_monitors;
            }
        }
    }
}

