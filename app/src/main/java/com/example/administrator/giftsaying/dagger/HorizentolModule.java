package com.example.administrator.giftsaying.dagger;

import android.content.Context;

import com.example.administrator.giftsaying.model.IHorizontalModel;
import com.example.administrator.giftsaying.model.impl.HorizontalModel;
import com.example.administrator.giftsaying.presenter.IHorizontalPresenter;
import com.example.administrator.giftsaying.presenter.impl.HorizontalPresenter;

import dagger.Module;
import dagger.Provides;

/**
 *
 * Created by Administrator on 2017/2/12.
 */
@Module
public class HorizentolModule {
    private IHorizontalPresenter.SendHorizontalResult result;
    private Context context;
    public HorizentolModule(IHorizontalPresenter.SendHorizontalResult result,Context context){
        this.result = result;
        this.context = context;
    }
    @Provides
    public IHorizontalModel getModel(){
        return new HorizontalModel();
    }
    @Provides
    public IHorizontalPresenter getPresenter(IHorizontalModel model){
        return new HorizontalPresenter(context,result);
    }
}
