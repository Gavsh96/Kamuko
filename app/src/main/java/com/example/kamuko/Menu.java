package com.example.kamuko;

import java.util.ArrayList;
import java.util.Iterator;

public class Menu {
    String id;
    String name;
    Integer img;
    String restId;
    double price;
    String description;

    public Menu(String id, String name, Integer img, String restId, double price, String description) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.restId = restId;
        this.price = price;
        this.description = description;
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

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

    public String getRestId() {
        return restId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
