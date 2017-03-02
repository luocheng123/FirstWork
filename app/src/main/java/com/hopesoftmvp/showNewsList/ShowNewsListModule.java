package com.hopesoftmvp.showNewsList;

import dagger.Module;
import dagger.Provides;
/**
 * Created by lenovo on 2017/2/16.
 */

@Module
public class ShowNewsListModule {

    private final ShowNewsListContract.View  view;

    public ShowNewsListModule(ShowNewsListContract.View  view){
        this.view=view;
    }
}
