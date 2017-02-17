package com.example.administrator.giftsaying.dagger;

import android.content.Context;

import com.example.administrator.giftsaying.model.IHomeModel;
import com.example.administrator.giftsaying.model.impl.HomeModel;
import com.example.administrator.giftsaying.presenter.IHomePresenter;
import com.example.administrator.giftsaying.presenter.impl.HomePresenter;

import dagger.Module;
import dagger.Provides;

/**
 *
 * Created by Administrator on 2017/2/9.
 */

@Module
public class HomeModule {
    private IHomePresenter.SendChoiceResult result;
    private int channel;
    private Context context;
    public HomeModule(IHomePresenter.SendChoiceResult result,Context context,int channel){
        this.result = result;
        this.context = context;
        this.channel = channel;
    }
    @Provides
    public IHomeModel getHomeModel(){
        return new HomeModel();
    }
    @Provides
    public IHomePresenter getHomepresnter(IHomeModel model){
        return new HomePresenter(result,model,context,channel);
    }
}
