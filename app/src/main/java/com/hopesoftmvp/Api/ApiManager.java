package com.hopesoftmvp.Api;

import com.hopesoftmvp.Bean.NeedData;
import com.hopesoftmvp.Bean.NewsDetail;
import com.hopesoftmvp.Bean.NewsList;
import com.hopesoftmvp.Bean.Uses;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by lenovo on 2017/2/16.
 */
public class ApiManager {

//    private static  final Retrofit  retrofit=new Retrofit.Builder()
//            .baseUrl("http://news-at.zhihu.com/api/4/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 使用RxJava作为回调适配器
//            .build();


    private static  final Retrofit  retrofit=new Retrofit.Builder()
            .baseUrl("http://f.apiplus.cn/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 使用RxJava作为回调适配器
            .build();

    private static  final  ApiManagerService apiManagerService= retrofit.create(ApiManagerService.class);

    public  static Observable<NewsList> getLatestNews(){
        return apiManagerService.getLatestNews();
    }

    public  static  Observable<NewsList> getBeforeNews(String date){
        return apiManagerService.getBeforeNews(date);
    }

    public  static  Observable<NewsDetail> getNewsDetail(int id){
        return  apiManagerService.getNewsDetail(id);
    }

    public  static Observable<NeedData> getNeedData(){
        System.out.println("---bbbbbbbb--111---" +"ApiManager");
        return apiManagerService.getNeedData();
    }
}
