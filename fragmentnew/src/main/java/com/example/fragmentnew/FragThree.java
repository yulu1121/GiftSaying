package com.example.fragmentnew;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 *
 * Created by Administrator on 2017/6/4.
 */

public class FragThree extends Fragment {
    private Context mContext;
    public static FragThree getInstance(){
        return new FragThree();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = LayoutInflater.from(mContext).inflate(R.layout.frag_three,container,false);
        return view;
    }
}

