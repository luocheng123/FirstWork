package com.hopesoftmvp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hopesoftmvp.Bean.NeedDataDetail;
import com.hopesoftmvp.Bean.News;
import com.hopesoftmvp.Bean.Uses;
import com.hopesoftmvp.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/2/16.
 */
public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>{

    private Context mContext;
//    private List<News> mNewsList;
    private List<NeedDataDetail> mNewsList;
    private long lastPos = -1;

//    public NewsListAdapter(Context context, List<News> newsList){
//        this.mContext = context;
//        this.mNewsList = newsList;
//    }


    public NewsListAdapter(Context context, List<NeedDataDetail> newsList){
        this.mContext = context;
        this.mNewsList = newsList;
    }
    @Override
    public NewsListAdapter.NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_list,null);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsListAdapter.NewsViewHolder holder, int position) {
//        final News news = mNewsList.get(position);
//        if(news == null){
//            return;
//        }
//        bindViewHolder(holder,position,news);

        final NeedDataDetail needDataDetail = mNewsList.get(position);
        if(needDataDetail == null){
            return;
        }
        bindViewHolder(holder,position,needDataDetail);
    }

//    private void bindViewHolder(NewsViewHolder holder, int position, News news) {
//        holder.mTvTitle.setText(news.getTitle());
//        List<String> images = news.getImages();
//        if(images != null && images.size() > 0){
//            Glide.with(mContext).load(images.get(0)).placeholder(R.drawable.ic_placeholder).into(holder.mIvNews);
//            holder.mCvItem.setOnClickListener(getListener(holder,news));
//        }
//    }

     private void bindViewHolder(NewsViewHolder holder, int position,NeedDataDetail needDataDetail) {
        holder.mTvTitle.setText(needDataDetail.getExpect());
    }
    private View.OnClickListener getListener(NewsViewHolder holder, final News news) {
        return new View.OnClickListener(){

            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mContext, NewDetailActivity.class);
//                intent.putExtra("new",news.getId());
//                mContext.startActivity(intent);
            }
        };
    }

    @Override
    public int getItemCount() {
        return mNewsList == null ? 0 : mNewsList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.cv_item)
        RelativeLayout mCvItem;

        @Bind(R.id.iv_news)
        ImageView mIvNews;

        @Bind(R.id.tv_title)
        TextView mTvTitle;

        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
