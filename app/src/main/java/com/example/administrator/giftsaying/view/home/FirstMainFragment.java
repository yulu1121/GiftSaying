package com.example.administrator.giftsaying.view.home;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.example.administrator.giftsaying.R;
import com.example.administrator.giftsaying.adapter.ExpandableAdapter;
import com.example.administrator.giftsaying.dagger.DaggerHomeComponent;
import com.example.administrator.giftsaying.dagger.HomeModule;
import com.example.administrator.giftsaying.model.bean.BannerBean;
import com.example.administrator.giftsaying.model.bean.ChoiceBean;
import com.example.administrator.giftsaying.model.bean.HorizontalBean;
import com.example.administrator.giftsaying.presenter.IHomePresenter;
import com.example.administrator.giftsaying.presenter.IHorizontalPresenter;
import com.example.administrator.giftsaying.presenter.impl.HorizontalPresenter;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshExpandableListView;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 *
 * Created by Administrator on 2017/2/7.
 */

public class FirstMainFragment extends Fragment implements IHomePresenter.SendChoiceResult,IHorizontalPresenter.SendHorizontalResult{
    private Context context;
    private int channel=101;
    private ExpandableAdapter adapter;//分组适配器
    private Map<String,List<ChoiceBean.DataBean.ItemsBean>> choiceMap = new LinkedHashMap<>();//存放ItemsBean的集合
    @BindView(R.id.first_main_expandable_ep)
    PullToRefreshExpandableListView expandableListView;//使用依赖注入创建的分组ListView
    @Inject
    IHomePresenter presenter;//使用dagger2创建的P层对象
    IHorizontalPresenter horizontalPresenter;
    private ConvenientBanner convenientBanner;//广告轮播器
    private LinearLayout liner;
    private List<HorizontalBean.DataBean.SecondaryBannersBean> horizontalBeanList=new ArrayList<>();
    private List<BannerBean.DataBean.BannersBean> bannersBeanList = new ArrayList<>();//存放广播类的集合
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerHomeComponent.builder().homeModule(new HomeModule(this,context,channel)).build().inject(this);
        horizontalPresenter = new HorizontalPresenter(context,this);
        presenter.getChoiceBeanResult();
        horizontalPresenter.getHorizontalResult();
    }

    @Override
    public void onStart() {
        super.onStart();
        //设置轮播时间
        convenientBanner.startTurning(3000);
    }

    @Override
    public void onStop() {
        super.onStop();
        //停止轮播
        convenientBanner.stopTurning();
    }
    public static FirstMainFragment newInstance(){
        return new FirstMainFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_main_layout, container, false);
        ButterKnife.bind(this,view);
        presenter.getBannerBeanResultl();
        initHeaderView();
        initExpandableList();
        initLinear(horizontalBeanList);
        return view;
    }

    /**
     * 初始化广告界面
     */
    private void initHeaderView(){
        View view = LayoutInflater.from(context).inflate(R.layout.first_main_header, null);
        HeaderViewHolder viewHolder = new HeaderViewHolder(view);
        expandableListView.getRefreshableView().addHeaderView(view);
        convenientBanner = viewHolder.banner;
        liner = viewHolder.linearLayout;
    }
    private void initLinear(List<HorizontalBean.DataBean.SecondaryBannersBean> horizontalBeanList) {
        liner.setBackgroundColor(Color.WHITE);
        final LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(100,100);
        lp.setMargins(10,10,10,10);
        Observable.from(horizontalBeanList)
                .map(new Func1<HorizontalBean.DataBean.SecondaryBannersBean, String>() {
                    @Override
                    public String call(HorizontalBean.DataBean.SecondaryBannersBean secondaryBannersBean) {
                        return secondaryBannersBean.getImage_url();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        ImageView imageView = new ImageView(context);
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        Picasso.with(context).load(s).into(imageView);
                        liner.addView(imageView,lp);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }, new Action0() {
                    @Override
                    public void call() {
                    }
                });
    }
    @Override
    public void sendHorizontalReasult(HorizontalBean bean) {
        horizontalBeanList.addAll(bean.getData().getSecondary_banners());
        initLinear(horizontalBeanList);
    }

    class HeaderViewHolder{
        @BindView(R.id.first_main_heaer_cb)
        ConvenientBanner banner;
        @BindView(R.id.first_main_ll)
        LinearLayout linearLayout;
        HeaderViewHolder(View view){
            ButterKnife.bind(this,view);
        }
    }
    /**
     * 初始化分组列表
     * */
    private void initExpandableList(){
        adapter = new ExpandableAdapter(choiceMap,context);
//        expandableListView.getRefreshableView().setDivider(getResources().getDrawable(R.drawable.divider_height));
        expandableListView.getRefreshableView().setDividerHeight(0);
        expandableListView.getRefreshableView().setGroupIndicator(null);
        expandableListView.getRefreshableView().setAdapter(adapter);
        expandableListView.setMode(PullToRefreshBase.Mode.BOTH);
        expandableListView.getRefreshableView().setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });
        expandableListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ExpandableListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ExpandableListView> refreshView) {
                adapter.notifyDataSetChanged();
                expandableListView.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ExpandableListView> refreshView) {
                adapter.notifyDataSetChanged();
                expandableListView.onRefreshComplete();
            }
        });
    }
    @Override
    public void sendChoiceBeanResult(ChoiceBean bean) {
        final List<ChoiceBean.DataBean.ItemsBean> items = bean.getData().getItems();
        Observable.from(items)
                  .flatMap(new Func1<ChoiceBean.DataBean.ItemsBean, Observable<ChoiceBean.DataBean.ItemsBean>>() {
                    @Override
                    public Observable<ChoiceBean.DataBean.ItemsBean> call(ChoiceBean.DataBean.ItemsBean itemsBean) {
                        long time= itemsBean.getCreated_at();
                        String formatTime = formatTime(time);
                        if(!choiceMap.containsKey(formatTime)){
                            choiceMap.put(formatTime,new ArrayList<ChoiceBean.DataBean.ItemsBean>());
                        }
                        choiceMap.get(formatTime).add(itemsBean);
                        return Observable.from(choiceMap.get(formatTime));
                    }
                })
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Action1<ChoiceBean.DataBean.ItemsBean>() {
                    @Override
                    public void call(ChoiceBean.DataBean.ItemsBean itemsBean) {

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }, new Action0() {
                    @Override
                    public void call() {
                        adapter.notifyDataSetChanged();
                        expandListView();
                    }
                });
    }

    /**
     * 设置广告界面
     * @param convenientBanner
     */
    private void setupBanner(ConvenientBanner convenientBanner){
        convenientBanner.setPages(new CBViewHolderCreator<FirstMainBannerCreater>() {
            @Override
            public FirstMainBannerCreater createHolder() {
                return new FirstMainBannerCreater();
            }
        },bannersBeanList)
        .setPageIndicator(new int[]{R.drawable.dot_unselected,R.drawable.dot_selected})
        .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
    }

    /**
     * Banner创建类
     */
    class FirstMainBannerCreater implements Holder<BannerBean.DataBean.BannersBean>{
        private ImageView imageView;
        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, BannerBean.DataBean.BannersBean data) {
            Picasso.with(context).load(data.getImage_url()).into(imageView);
        }
    }
    @Override
    public void sendBannerBeanResult(final BannerBean bannerBean) {
        bannersBeanList.clear();
        bannersBeanList.addAll(bannerBean.getData().getBanners());
        setupBanner(convenientBanner);
        convenientBanner.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 使组无法收缩
     */
    private void expandListView() {
        Object[] objects = choiceMap.keySet().toArray();
        int size = objects.length ;
        for (int i = 0; i < size; i++) {
            ExpandableListView refreshableView = expandableListView.getRefreshableView();
            refreshableView.expandGroup(i);
        }
    }

    /**
     * 日期格式
     * @param time
     * @return String
     */
    private String formatTime(long time){
        Date date = new Date(time*1000);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
}
