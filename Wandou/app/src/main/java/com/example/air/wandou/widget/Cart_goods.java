package com.example.air.wandou.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.air.wandou.R;

/**
 * Created by Air on 2017/8/13.
 */

public class Cart_goods extends LinearLayout{

    public Cart_goods(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_cart_item,this);
    }
}
