package com.example.air.wandou.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.air.wandou.R;
import com.example.air.wandou.bean.Address;

import java.util.List;

/**
 * Created by Air on 2017/9/8.
 */

public class AddressAdapter extends Adapter<AddressAdapter.ViewHolder> {

    private List<Address> mAddressList;


    static class ViewHolder extends RecyclerView.ViewHolder {
        View addressview;
        TextView tv_name;
        TextView tv_phone;
        TextView tv_addr;

        public ViewHolder(View itemView) {
            super(itemView);
            addressview = itemView;
            tv_name = (TextView) itemView.findViewById(R.id.txt_name);
            tv_phone = (TextView) itemView.findViewById(R.id.txt_mobile);
            tv_addr = (TextView) itemView.findViewById(R.id.txt_address);
        }
    }

    public AddressAdapter(List<Address> addressList) {
        mAddressList = addressList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_address_item, parent, false);
        ViewHolder holder =new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Address address = mAddressList.get(position);
        holder.tv_name.setText(address.getName());
        holder.tv_phone.setText(address.getPhone());
        holder.tv_addr.setText(address.getAddress());
    }

    @Override
    public int getItemCount() {
        return mAddressList.size();
    }


}
