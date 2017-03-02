package com.hopesoftmvp;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lenovo on 2017/2/15.
 */
@Module
public class ApplicationModule {

    private Context context;
    public ApplicationModule(Context context){
        this.context=context;
    }

    @Provides
    public  Context provideContext(){
        return  context;
    }

}
