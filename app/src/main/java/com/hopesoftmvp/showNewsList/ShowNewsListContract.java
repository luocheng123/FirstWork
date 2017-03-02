package com.hopesoftmvp.showNewsList;

import com.hopesoftmvp.BasePersenter;
import com.hopesoftmvp.BaseView;
import com.hopesoftmvp.Bean.NeedDataDetail;
import com.hopesoftmvp.Bean.News;
import com.hopesoftmvp.Bean.Uses;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/2/16.
 */
public interface ShowNewsListContract {

    interface  View extends BaseView{
//        void load(ArrayList<News> list);
        void refresh(ArrayList<News> list);

        void load(ArrayList<NeedDataDetail> list);

    }

    interface Presenter extends BasePersenter<View>{
        void getBeforeNewsListData(String date);
        void getNewsListData();
        void getRefreshNewsListData();

        void getNeedData();
    }
}
