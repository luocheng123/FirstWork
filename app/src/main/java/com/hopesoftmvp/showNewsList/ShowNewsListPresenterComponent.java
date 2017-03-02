package com.hopesoftmvp.showNewsList;

import com.hopesoftmvp.ApplicationComponent;
import dagger.Component;

/**
 * Created by lenovo on 2017/2/16.
 */

@Component(dependencies = ApplicationComponent.class,modules = ShowNewsListModule.class)
public interface ShowNewsListPresenterComponent {

    void inject(ShowNewsListActivity showNewsListActivity);
}
