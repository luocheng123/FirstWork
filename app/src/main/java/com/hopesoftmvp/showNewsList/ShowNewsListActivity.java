package com.hopesoftmvp.showNewsList;

import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;

import com.hopesoftmvp.Bean.NeedDataDetail;
import com.hopesoftmvp.Bean.Uses;
import com.hopesoftmvp.adapter.NewsListAdapter;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.hopesoftmvp.ApplicationComponent;
import com.hopesoftmvp.BaseActivity;
import com.hopesoftmvp.Bean.News;
import com.hopesoftmvp.R;


/**
 * Created by lenovo on 2017/2/16.
 */
public class ShowNewsListActivity extends BaseActivity implements  ShowNewsListContract.View{

    @Bind(R.id.recyclerview)
    XRecyclerView mxRecyclerView;

    private NewsListAdapter newsListAdapter;
//    private  List<News> listData = new ArrayList<>();
    private  List<NeedDataDetail> listData = new ArrayList<>();

    @Inject
    ShowNewsListPresenter showNewsListPresenter;

    @Override
    protected void initUi() {
        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mxRecyclerView.setLayoutManager(layoutManager);

        mxRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);//设置刷新类型
        mxRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.Pacman);//设置加载类型
//        mRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);//设置下拉箭头
//        mxRecyclerView.setRefreshing(true);
        mxRecyclerView.setPullRefreshEnabled(true);
    }

    @Override
    protected void initDatas() {

        newsListAdapter = new NewsListAdapter(this, listData);
        mxRecyclerView.setAdapter(newsListAdapter);

        showNewsListPresenter.attachView(this);
//        Log.i("AAAAA","------11111----");
//        System.out.println("---1111111--" +"---0000000000000000----" );
//        showNewsListPresenter.getNewsListData();

        Log.i("AAAAA","------11111----");
        System.out.println("---1111111--" +"---0000000000000000----" );
        showNewsListPresenter.getNeedData();
    }

    @Override
    protected void initListener() {

        mxRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        showNewsListPresenter.getRefreshNewsListData();
                        mxRecyclerView.refreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        showNewsListPresenter.getBeforeNewsListData("20160811");
                        mxRecyclerView.loadMoreComplete();

                    }
                }, 1000);
            }
        });

    }

    @Override
    protected void onclick() {

    }

    @Override
    protected void setupComponent(ApplicationComponent component) {
        DaggerShowNewsListPresenterComponent.builder().applicationComponent(component).showNewsListModule(new ShowNewsListModule(this)).build().inject(this);
    }

    @Override
    public int initContentView() {
        return R.layout.activity_base;
    }

//    @Override
//    public void load(ArrayList<News> list) {
//        for (int z = 0; z < list.size(); z++) {
//            listData.add(list.get(z));
//        }
//        newsListAdapter.notifyDataSetChanged();
//    }

    @Override
    public void load(ArrayList<NeedDataDetail> list) {
        for (int z = 0; z < list.size(); z++) {
            listData.add(list.get(z));
        }
        newsListAdapter.notifyDataSetChanged();
    }

    @Override
    public void refresh(ArrayList<News> list) {
        listData.clear();
        for (int z = 0; z < list.size(); z++) {
//            listData.add(list.get(z));
        }
        newsListAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showNewsListPresenter.detachView();
    }
}
