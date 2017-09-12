package com.example.air.wandou.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.air.wandou.R;
import com.example.air.wandou.bean.Commodity;

import java.util.List;

/**
 * Created by Air on 2017/8/14.
 */

public class CommodityAdapter extends RecyclerView.Adapter<CommodityAdapter.ViewHolder> {
    private List<Commodity> mCommodityList;

    private boolean checkAll = false;


    public interface OnClickListener {
        void setOnClick(View view, int position);
    }

    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener OnClickListener) {
        this.onClickListener = OnClickListener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View commodityView;
        ImageView image;
        TextView name, count, price;
        ImageButton add, subtract, delete;
        CheckBox checkBox;

        public ViewHolder(View view) {
            super(view);
            commodityView = view;
            image = (ImageView) view.findViewById(R.id.cart_img);
            name = (TextView) view.findViewById(R.id.cart_goods);
            count = (TextView) view.findViewById(R.id.cart_count);
            price = (TextView) view.findViewById(R.id.cart_price);
            add = (ImageButton) view.findViewById(R.id.cart_add);
            subtract = (ImageButton) view.findViewById(R.id.cart_subtract);
            delete = (ImageButton) view.findViewById(R.id.cart_delete);
            checkBox = (CheckBox) view.findViewById(R.id.cart_check);
        }
    }

    public CommodityAdapter(List<Commodity> commodityList) {
        mCommodityList = commodityList;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_cart_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Commodity commodity = mCommodityList.get(position);
                commodity.setCount(commodity.getCount() + 1);
                holder.count.setText("" + commodity.getCount());
                holder.price.setText(commodity.TotalToString());
                onClickListener.setOnClick(v, position);
            }
        });

        holder.subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Commodity commodity = mCommodityList.get(position);
                if (commodity.getCount() > 1) {
                    commodity.setCount(commodity.getCount() - 1);
                } else {
                    Toast.makeText(v.getContext(), "不能再少了", Toast.LENGTH_SHORT).show();
                }
                holder.count.setText("" + commodity.getCount());
                holder.price.setText(commodity.TotalToString());
                onClickListener.setOnClick(v, position);
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                mCommodityList.remove(position);
                notifyItemRemoved(position);
                onClickListener.setOnClick(v, position);
            }
        });

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Commodity commodity = mCommodityList.get(position);
                if (commodity.isCheck()) {
                    commodity.setCheck(false);
                } else {
                    commodity.setCheck(true);
                }
                onClickListener.setOnClick(v, position);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Commodity commodity = mCommodityList.get(position);
        holder.image.setImageResource(commodity.getImgeId());
        holder.name.setText(commodity.getName());
        holder.price.setText(commodity.TotalToString());
        holder.count.setText(commodity.CountToString());
        holder.checkBox.setChecked(commodity.isCheck());
    }

    @Override
    public int getItemCount() {
        return mCommodityList.size();
    }

    //已经选择的个数
    public String isChose() {
        int total = 0;
        int money = 0;
        for (int i = 0; i < getItemCount(); i++) {
            Commodity commodity = mCommodityList.get(i);
            if (commodity.isCheck()) {
                money += commodity.getTotal();
                total += commodity.getCount();
            }
        }
        return "共<font color='#eb4f38'>" + total + "</font>件商品，合计<font color='#eb4f38'>" + (double) money / 100 + "</font>";
    }

    //全选
    public void CheckAll() {
        if (checkAll) {
            for (int i = 0; i < getItemCount(); i++) {
                Commodity commodity = mCommodityList.get(i);
                commodity.setCheck(false);
                checkAll=false;
            }
        } else {
            for (int i = 0; i < getItemCount(); i++) {
                Commodity commodity = mCommodityList.get(i);
                commodity.setCheck(true);
                checkAll=true;
            }
        }

    }
}
