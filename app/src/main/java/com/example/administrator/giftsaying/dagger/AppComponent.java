package com.example.administrator.giftsaying.dagger;

import com.example.administrator.giftsaying.MainActivity;

import dagger.Component;

/**
 *
 * Created by Administrator on 2017/2/7.
 */
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
}
