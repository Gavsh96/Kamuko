package com.example.kamuko;

public class OrderHistory {

    String userId;
    String items;
    String date;
    String restaurantName;
    Double cost;



    public OrderHistory(String userId, String items, String date, String restaurantName, Double cost)
    {
        this.userId = userId;
        this.items = items;
        this.date = date;
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

    public String getRestaurantName() { return restaurantName; }

    public void setRestaurantName(String restaurantName) { this.restaurantName = restaurantName; }

    public Double getCost() { return cost; }

    public void setTime(Double cost) { this.cost = cost; }
}
