package com.example.air.wandou.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.air.wandou.R;
import com.example.air.wandou.bean.Commodity;

import java.util.List;

/**
 * Created by Air on 2017/8/31.
 */

public class MallAdapter extends RecyclerView.Adapter<MallAdapter.ViewHolder> {
    private Context mContext;
    private List<Commodity> mCommodityList;

    public MallAdapter(List<Commodity> commodityList) {
        mCommodityList = commodityList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext=parent.getContext();
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_mall_tiem, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Commodity commodity = mCommodityList.get(position);
        holder.name.setText(commodity.getName());
        holder.price.setText(commodity.TotalToString());
        Glide.with(mContext).load(commodity.getImgeId()).into(holder.image);

        holder.commodityView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mCommodityList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        View commodityView;
        ImageView image;
        TextView name, price;

        public ViewHolder(View itemView) {
            super(itemView);
            commodityView = itemView;
            image = (ImageView) itemView.findViewById(R.id.mall_imge);
            name = (TextView) itemView.findViewById(R.id.mall_name);
            price = (TextView) itemView.findViewById(R.id.mall_price);
        }
    }
}
