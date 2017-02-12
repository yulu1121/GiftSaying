package com.example.administrator.giftsaying.dagger;

import com.example.administrator.giftsaying.view.home.FirstMainFragment;

import dagger.Component;

/**
 *
 * Created by Administrator on 2017/2/9.
 */
@Component(modules = HomeModule.class)
public interface HomeComponent {
    void inject(FirstMainFragment fragment);
}
