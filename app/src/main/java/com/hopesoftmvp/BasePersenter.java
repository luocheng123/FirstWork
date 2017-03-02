package com.hopesoftmvp;

import android.support.annotation.NonNull;

/**
 * Created by lenovo on 2017/2/16.
 */
public interface BasePersenter<T extends BaseView>{
    //绑定view，这个方法将会在activity中调用
    void attachView(@NonNull T view);
    //解绑
    void detachView();
}
