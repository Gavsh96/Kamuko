package com.example.kamuko;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Restaurant {
    String id;
    String name;
    Integer img;

    public Restaurant(String id, String name, Integer img)
    {
        this.id = id;
        this.name = name;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImg() { return img; }

    public void setImg(Integer img) { this.img = img; }

}
