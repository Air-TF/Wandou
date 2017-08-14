package com.example.air.wandou.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.air.wandou.R;
import com.example.air.wandou.bean.Commodity;

import java.util.List;

/**
 * Created by Air on 2017/8/14.
 */

public class CommodityAdapter extends RecyclerView.Adapter<CommodityAdapter.ViewHolder> {
    private List<Commodity> mCommodityList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View commodityView;
        ImageView image;
        TextView name, count, price;
        ImageButton add,subtract;

        public ViewHolder(View view) {
            super(view);
            commodityView=view;
            image = (ImageView) view.findViewById(R.id.cart_img);
            name = (TextView) view.findViewById(R.id.cart_goods);
            count= (TextView) view.findViewById(R.id.cart_count);
            price = (TextView) view.findViewById(R.id.cart_price);
            add= (ImageButton) view.findViewById(R.id.cart_add);
            subtract = (ImageButton) view.findViewById(R.id.cart_subtract);
        }
    }

    public CommodityAdapter(List<Commodity> commodityList){
        mCommodityList=commodityList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_cart_item,parent,false);
        final ViewHolder holder =new ViewHolder(view);
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position =holder.getAdapterPosition();
                Commodity commodity=mCommodityList.get(position);
                holder.count.setText("2");
            }
        });


        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Commodity commodity =mCommodityList.get(position);
        holder.image.setImageResource(commodity.getImgeId());
        holder.name.setText(commodity.getName());
        holder.price.setText(commodity.getPrice());
    }

    @Override
    public int getItemCount() {
        return mCommodityList.size();
    }


}
