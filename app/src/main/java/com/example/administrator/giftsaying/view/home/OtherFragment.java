package com.example.administrator.giftsaying.view.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.giftsaying.R;
import com.example.administrator.giftsaying.adapter.OtherFragmentAdapter;
import com.example.administrator.giftsaying.model.bean.BannerBean;
import com.example.administrator.giftsaying.model.bean.ChoiceBean;
import com.example.administrator.giftsaying.presenter.IHomePresenter;
import com.example.administrator.giftsaying.presenter.impl.HomePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 * Created by Administrator on 2017/2/7.
 */

public class OtherFragment extends Fragment implements IHomePresenter.SendChoiceResult{
    private Context context;
    public static final String PARAM_TYPR = "type";
    private int type;
    IHomePresenter presenter;
    private List<ChoiceBean.DataBean.ItemsBean> itemsBeanList = new ArrayList<>();
    @BindView(R.id.other_channel_list)
    ListView listView;
    private OtherFragmentAdapter adapter;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
    public static OtherFragment newInstance(int type){
        OtherFragment otherFragment = new OtherFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(PARAM_TYPR,type);
        otherFragment.setArguments(bundle);
        return otherFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        type = bundle.getInt(PARAM_TYPR);
        presenter = new HomePresenter(this,context,type);
        presenter.getChoiceBeanResult();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.other_channel_layout, container, false);
        ButterKnife.bind(this,view);
        initOtherFragView();
        return view;
    }
    private void initOtherFragView(){
        adapter = new OtherFragmentAdapter(context,itemsBeanList);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    @Override
    public void sendChoiceBeanResult(ChoiceBean bean) {
//        List<ChoiceBean.DataBean.ItemsBean> items = bean.getData().getItems();
        itemsBeanList.addAll(bean.getData().getItems());
        initOtherFragView();
    }

    @Override
    public void sendBannerBeanResult(BannerBean bannerBean) {

    }
}
