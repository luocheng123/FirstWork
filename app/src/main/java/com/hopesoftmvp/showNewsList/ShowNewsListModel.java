package com.hopesoftmvp.showNewsList;

import com.hopesoftmvp.Api.ApiManager;
import com.hopesoftmvp.Bean.NeedData;
import com.hopesoftmvp.Bean.NewsList;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by lenovo on 2017/2/16.
 */
public class ShowNewsListModel {

    @Inject
    public ShowNewsListModel(){

    }

    Observable<NewsList> getLatestNews(){
        return ApiManager.getLatestNews();
    }

    Observable<NewsList> getBeforeNews(String date){
        return  ApiManager.getBeforeNews(date);
    }

    Observable<NewsList> getRefreshNewsListData(){
        return  ApiManager.getLatestNews();
    }

    Observable<NeedData> getNeedData(){
        System.out.println("---bbbbbbb---111---" +"ShowNewsListModel");
        return ApiManager.getNeedData();
    }
}
