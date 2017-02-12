package com.example.administrator.giftsaying;

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
    @Inject
    ICategoryPresenter presenter;
    private FirstMainFragment firstMainFragment=FirstMainFragment.newInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DaggerAppComponent.builder().appModule(new AppModule(this,getApplicationContext())).build().inject(this);
        presenter.getCategoryResult();
    }
    public void initFragments(){
        fragmentList = new ArrayList<>();
        fragmentList.add(firstMainFragment);
        for (int i = 0; i < mlist.size()-1; i++) {
            fragmentList.add(OtherFragment.newInstance("111"+i));
        }
    }
    private void initView(){
        mainTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        adapter = new FragmentAdapter(getSupportFragmentManager(),fragmentList,mlist);
        mainViewPager.setAdapter(adapter);
        mainTabLayout.setupWithViewPager(mainViewPager);
    }
    @Override
    public void sendCategoryResult(TopCategoryBean bean) {
        mlist = new ArrayList<>();
        List<TopCategoryBean.DataBean.ChannelsBean> channels = bean.getData().getChannels();
        for (int i = 0; i < channels.size() ; i++) {
            mlist.add(channels.get(i).getName());
        }
        initFragments();
        initView();
    }


}
