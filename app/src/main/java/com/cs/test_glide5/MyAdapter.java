package com.cs.test_glide5;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by chenshuai on 2016/11/14.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHodler> {
    private Context context;
    private List<String> mDatas;
    private List<Integer> mHeights;
    private int imageWidth;
    public OnItemClickLitener mOnItemClickLitener;
    /**
     * 6
     *  定义点击事件的接口
     */

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);

    }
    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public MyAdapter(Context context, List<String> mDatas) {
        this.context = context;
        this.mDatas = mDatas;

    }


    public MyAdapter(Context context, List<String> mDatas, List<Integer> mHeights) {
        this.context = context;
        this.mDatas = mDatas;
        this.mHeights = mHeights;
    }

    @Override
    public MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_photo, parent, false);
        MyViewHodler hodler = new MyViewHodler(view);
        return hodler;
    }

    @Override
    public void onBindViewHolder(final MyViewHodler holder, final int position) {
        ViewGroup.LayoutParams lp = holder.imageView.getLayoutParams();
        lp.height = mHeights.get(position);
        imageWidth=context.getResources().getDisplayMetrics().widthPixels/3;
        lp.width = imageWidth;
        holder.imageView.setLayoutParams(lp);
        Glide.with(context)
                .load(mDatas.get(position))
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .crossFade()
                .into(holder.imageView);
        if (mOnItemClickLitener!=null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView,pos);
                }
            });

        }

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHodler extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public MyViewHodler(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
