package com.hopesoftmvp.showNewsList;

import android.support.annotation.NonNull;
import android.util.Log;

import com.hopesoftmvp.Bean.NeedData;
import com.hopesoftmvp.Bean.NeedDataDetail;
import com.hopesoftmvp.Bean.News;
import com.hopesoftmvp.Bean.NewsList;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/2/16.
 */
public class ShowNewsListPresenter implements ShowNewsListContract.Presenter{

    private ShowNewsListContract.View view;
    private Subscription mSubscription;
    private ArrayList<News> listdata=new ArrayList<>();

    @Inject
    ShowNewsListModel showNewsListModel;
    @Inject
    public  ShowNewsListPresenter(){}


    @Override
    public void getBeforeNewsListData(String date) {
        mSubscription=showNewsListModel.getBeforeNews(date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NewsList>() {
                    @Override
                    public void call(NewsList newsList) {
                        for (int i = 0; i< newsList.getStories().size(); i++) {
                            listdata.add(newsList.getStories().get(i));
                        }
//                        view.load(listdata);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        System.out.println("----1---onFailure--" + throwable.getMessage());
                    }
                });
    }

    @Override
    public void getNewsListData() {
        Log.i("AAAAA","---222---fffffffffffffff----");
        System.out.println("---2----onFailure--" +"---222---fffffffffffffff----" );
        mSubscription =showNewsListModel.getLatestNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NewsList>() {
                    @Override
                    public void call(NewsList newsList) {
                        listdata.clear();
                        for (int z = 0; z < newsList.getStories().size(); z++) {
                            listdata.add(newsList.getStories().get(z));
                        }
                        view.refresh(listdata);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        System.out.println("---2----onFailure--" + throwable.getMessage());
                    }
                });
    }

    @Override
    public void getRefreshNewsListData() {
        Log.i("AAAAA","---333---fffffffffffffff----");
        System.out.println("---3----onFailure--" +"---333---fffffffffffffff----" );
        mSubscription = showNewsListModel.getLatestNews() //getRefreshNewsListData
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NewsList>() {
                    @Override
                    public void call(NewsList newsList) {
                        listdata.clear();
                        for (int z = 0; z < newsList.getStories().size(); z++) {
                            listdata.add(newsList.getStories().get(z));
                        }
                        view.refresh(listdata);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        System.out.println("---3----onFailure--" + throwable.getMessage());
                    }
                });
    }

    private ArrayList<NeedDataDetail> needDatalist=new ArrayList<>();

    @Override
    public void getNeedData() {

        Log.i("AAAAA","---55---fffffffffffffff----");
        System.out.println("---5------" +"ffffffffffffffff");

        mSubscription = showNewsListModel.getNeedData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NeedData>() {
                    @Override
                    public void call(NeedData needData) {

                        System.out.println("---5----seccues--" +" "+ needData.getCode()+" " + needData.getInfo()+" " + needData.getRows());
                        for (int i = 0; i< needData.getData().size(); i++) {
                            needDatalist.add( needData.getData().get(i));
                            System.out.println("---5----seccues--" +" "+ needData.getData().get(i).getExpect());
                        }
                        view.load(needDatalist);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        System.out.println("---5----onFailure--*" + throwable.getMessage());
                    }
                });
    }

    @Override
    public void attachView(@NonNull ShowNewsListContract.View view) {
        this.view=view;
    }

    @Override
    public void detachView() {
        if (mSubscription!=null && mSubscription.isUnsubscribed()){
            mSubscription.unsubscribe();
        }
        view =null;
    }
}
