package com.example.air.wandou.bean;

/**
 * Created by Air on 2017/8/14.
 */

public class Commodity {
    //名字
    private String name;
    //图片资源Id
    private int imgeId;
    //价格
    private int price,total;
    //数量
    private int count;
    //默认被选中
    private boolean isCheck;

    public Commodity(boolean isCheck,String name, int imgeId, int count, int price) {
        this.name = name;
        this.imgeId = imgeId;
        this.price = price;
        this.count = count;
        this.isCheck = isCheck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImgeId(int imgeId) {
        this.imgeId = imgeId;
    }

    public void setPrice(int price) {
        this.price = price*100;
    }

    public int getPrice() {
        return price/100;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public int getTotal() {
        return price*count;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public int getImgeId() {
        return imgeId;
    }

    public String CountToString() {
        return ""+count;
    }

    public String TotalToString() {
        return "￥"+(double)price*count/100;
    }

}
