package com.example.administrator.giftsaying.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 *
 * Created by Administrator on 2017/2/7.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private List<String> mlist;

    public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> mlist) {
        super(fm);
        this.fragmentList = fragmentList;
        this.mlist = mlist;
    }

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return null==fragmentList?0:fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mlist.get(position);
    }
}
