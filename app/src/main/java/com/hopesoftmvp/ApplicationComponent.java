package com.hopesoftmvp;

import dagger.Component;

/**
 * Created by lenovo on 2017/2/15.
 */

@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(MyApplication myApplication);
}
