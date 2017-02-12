package com.example.administrator.giftsaying.dagger;

import android.content.Context;

import com.example.administrator.giftsaying.model.ICategoryModel;
import com.example.administrator.giftsaying.model.impl.CategoryModel;
import com.example.administrator.giftsaying.presenter.ICategoryPresenter;
import com.example.administrator.giftsaying.presenter.impl.CategoryPresenter;

import dagger.Module;
import dagger.Provides;

/**
 *
 * Created by Administrator on 2017/2/7.
 */
@Module
public class AppModule {
    private ICategoryPresenter.SendCategoryResult result;
    private Context context;
    public AppModule(ICategoryPresenter.SendCategoryResult result,Context context) {
        this.result = result;
        this.context = context;
    }
    @Provides
    public ICategoryModel getCategoryModel(){
        return new CategoryModel();
    }
    @Provides
    public ICategoryPresenter getCategoryPresenter(ICategoryModel model){
        return new CategoryPresenter(result,model,context);
    }
}
