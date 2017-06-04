package com.example.fragmentnew;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Administrator on 2017/6/4.
 */

public class FragOne extends Fragment {
    private Context mContext;
    private ViewPager mViewPager;
    private List<Fragment> mList;
    private MyPagerAdapter pagerAdapter;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    public static FragOne getInstance(){
        return new FragOne();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.frag_one,container,false);
        initView(view);
        initFragments();
        return view;
    }

    private void initFragments() {
        mList = new ArrayList<>();
        mList.add(FragTwo.getInstance());
        mList.add(FragThree.getInstance());
        mList.add(FragFour.getInstance());
        pagerAdapter.notifyDataSetChanged();
    }

    private void initView(View view) {
        mViewPager = (ViewPager) view.findViewById(R.id.my_viewpager);
        pagerAdapter = new MyPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(pagerAdapter);
    }
    class MyPagerAdapter extends FragmentPagerAdapter{

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }

        @Override
        public int getCount() {
            return  null==mList?0:mList.size();
        }
    }
}
