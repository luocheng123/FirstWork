package com.hopesoftmvp.Api;


import com.hopesoftmvp.Bean.NeedData;
import com.hopesoftmvp.Bean.NewsDetail;
import com.hopesoftmvp.Bean.NewsList;
import com.hopesoftmvp.Bean.Uses;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by lenovo on 2017/2/16.
 */
public interface ApiManagerService {

    @GET("stories/latest")
    Observable<NewsList> getLatestNews();

    @GET("stories/before/{date}")
    Observable<NewsList> getBeforeNews(@Path("date") String date);

    @GET("story/{id}")
    Observable<NewsDetail> getNewsDetail(@Path("id") int id);

    @GET("cqssc.json")
    Observable<NeedData> getNeedData();
}
