package com.example.kamuko;


import android.os.Parcel;
import android.os.Parcelable;

public class Restaurant implements Parcelable{
    String id;
    String name;
    String img;


    public Restaurant(String id, String name, String img)
    {
        this.id = id;
        this.name = name;
        this.img = img;
    }

    protected Restaurant(Parcel in) {
        id = in.readString();
        name = in.readString();
        img = in.readString();
    }

    public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };

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

    public String getImg() { return img; }

    public void setImg(String img) { this.img = img; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(img);
    }
}
