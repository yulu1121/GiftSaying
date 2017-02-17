package com.example.administrator.giftsaying;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.giftsaying.adapter.FragmentAdapter;
import com.example.administrator.giftsaying.dagger.AppModule;
import com.example.administrator.giftsaying.dagger.DaggerAppComponent;
import com.example.administrator.giftsaying.model.bean.TopCategoryBean;
import com.example.administrator.giftsaying.presenter.ICategoryPresenter;
import com.example.administrator.giftsaying.view.home.FirstMainFragment;
import com.example.administrator.giftsaying.view.home.OtherFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ICategoryPresenter.SendCategoryResult {
    @BindView(R.id.main_tab_tl)
    TabLayout mainTabLayout;
    @BindView(R.id.main_view_pager_vp)
    ViewPager mainViewPager;
    private FragmentAdapter adapter;
    private List<String> mlist;
    private List<Fragment> fragmentList;
    private List<Integer> channelId;
    private ProgressDialog dialog;
    @Inject
    ICategoryPresenter presenter;
    private FirstMainFragment firstMainFragment=FirstMainFragment.newInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDialog();
        dialog.show();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DaggerAppComponent.builder().appModule(new AppModule(this,getApplicationContext())).build().inject(this);
        presenter.getCategoryResult();
    }
    private void initDialog(){
        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMax(100);
        dialog.setMessage("正在加载中...");
    }
    public void initFragments(){
        fragmentList = new ArrayList<>();
        fragmentList.add(firstMainFragment);
        for (int i = 1; i < mlist.size(); i++) {
            OtherFragment otherFragment = OtherFragment.newInstance(channelId.get(i));
            fragmentList.add(otherFragment);
        }
    }
    private void initView(){
        mainTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        adapter = new FragmentAdapter(getSupportFragmentManager(),fragmentList,mlist);
        mainViewPager.setAdapter(adapter);
        mainTabLayout.setupWithViewPager(mainViewPager);
        dialog.dismiss();
    }
    @Override
    public void sendCategoryResult(TopCategoryBean bean) {
        mlist = new ArrayList<>();
        channelId = new ArrayList<>();
        List<TopCategoryBean.DataBean.ChannelsBean> channels = bean.getData().getChannels();
        for (int i = 0; i < channels.size() ; i++) {
            mlist.add(channels.get(i).getName());
            channelId.add(channels.get(i).getId());
        }
        initFragments();
        initView();
    }

}
