package com.example.kamuko;

import java.util.ArrayList;

public class FoodData {
    String itemName;
    String des;
    Integer imgRef;

    public FoodData(String itemName, String des, Integer imgRef)
    {
        this.itemName = itemName;
        this.des = des;
        this.imgRef = imgRef;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Integer getImgRef() {
        return imgRef;
    }

    public void setImgRef(Integer imgRef) { this.imgRef = imgRef; }

}
