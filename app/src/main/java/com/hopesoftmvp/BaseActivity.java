package com.hopesoftmvp;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_base);

        setContentView(initContentView());
        setupComponent((ApplicationComponent) MyApplication.get(this).component());
        initUi();
        initDatas();
        initListener();
        onclick();
    }

    protected abstract void initUi();

    protected abstract void initDatas();

    protected abstract void initListener();

    protected abstract void onclick();

    protected abstract void setupComponent(ApplicationComponent component);//Dagger2绑定

    public abstract int initContentView();
}
