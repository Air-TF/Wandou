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
    private String price;
    //数量
    private String count;

    public Commodity(String name, int imgeId, String count,String price) {
        this.name = name;
        this.imgeId = imgeId;
        this.price = price;
        this.count = count;
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

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCount() {
        return count;
    }

    public int getImgeId() {
        return imgeId;
    }

    public String getPrice() {
        return price;
    }
}
