package com.example.kamuko;

public class OrderHistory {

    String userId;
    String items;
    String date;
    String time;
    String restaurantName;
    Integer cost;



    public OrderHistory(String userId, String items, String date, String time, String restaurantName, Integer cost)
    {
        this.userId = userId;
        this.items = items;
        this.date = date;
        this.time = time;
        this.restaurantName = restaurantName;
        this.cost = cost;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }

    public String getRestaurantName() { return restaurantName; }

    public void setRestaurantName(String restaurantName) { this.restaurantName = restaurantName; }

    public Integer getCost() { return cost; }

    public void setTime(Integer cost) { this.cost = cost; }
}
