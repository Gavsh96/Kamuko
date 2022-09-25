package com.example.kamuko;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DBModel {

    SQLiteDatabase db;

    public void load(Context context){
        this.db = new DBHelper(context).getWritableDatabase();
    }

    public void addRestaurant(Restaurant restaurant){
        ContentValues cv = new ContentValues();
        cv.put(DBSchema.restaurantTable.Cols.ID, restaurant.getId());
        cv.put(DBSchema.restaurantTable.Cols.NAME, restaurant.getName());
        cv.put(DBSchema.restaurantTable.Cols.IMAGE, restaurant.getImg());
        db.insert(DBSchema.restaurantTable.NAME, null, cv);
    }

    public ArrayList<Restaurant> getAllRestaurant(){
        ArrayList<Restaurant> restaurantList = new ArrayList<>();
        Cursor cursor = db.query(DBSchema.restaurantTable.NAME,null,null,null,null,null,null);
        DBCursor DBCursor = new DBCursor(cursor);

        try{
            DBCursor.moveToFirst();
            while(!DBCursor.isAfterLast()){
                restaurantList.add(DBCursor.getRestaurant());
                DBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return restaurantList;
    }

    public void deleteAllRestaurants()
    {
        db.delete(DBSchema.restaurantTable.NAME, null, null);
    }

    public void addMenu(Menu menu)
    {
        ContentValues cv = new ContentValues();
        cv.put(DBSchema.menuTable.Cols.ID, menu.getId());
        cv.put(DBSchema.menuTable.Cols.NAME, menu.getName());
        cv.put(DBSchema.menuTable.Cols.IMAGE, menu.getImg());
        cv.put(DBSchema.menuTable.Cols.RESTID, menu.getRestId());
        cv.put(DBSchema.menuTable.Cols.PRICE, menu.getPrice());
        cv.put(DBSchema.menuTable.Cols.DESCRIPTION, menu.getDescription());
        db.insert(DBSchema.menuTable.NAME, null, cv);
    }

    public ArrayList<Menu> getAllMenu()
    {
        ArrayList<Menu> menuArrayList = new ArrayList<>();
        Cursor cursor = db.query(DBSchema.menuTable.NAME, null,null,null,null,null,null);
        DBCursor DBCursor = new DBCursor(cursor);

        try
        {
            DBCursor.moveToFirst();
            while (!DBCursor.isAfterLast())
            {
                menuArrayList.add(DBCursor.getMenu());
                DBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }

        return menuArrayList;
    }

    public void deleteAllMenu()
    {
        db.delete(DBSchema.menuTable.NAME, null, null);
    }


    public void addUser(User user){
        ContentValues cv = new ContentValues();
        cv.put(DBSchema.userTable.Cols.ID, user.getUserId());
        cv.put(DBSchema.userTable.Cols.NAME, user.getName());
        cv.put(DBSchema.userTable.Cols.PASSWORD, user.getPassword());
        db.insert(DBSchema.userTable.NAME, null, cv);
    }

    public ArrayList<User> getAllUser(){
        ArrayList<User> userList = new ArrayList<>();
        Cursor cursor = db.query(DBSchema.userTable.NAME,null,null,null,null,null,null);
        DBCursor DBCursor = new DBCursor(cursor);

        try{
            DBCursor.moveToFirst();
            while(!DBCursor.isAfterLast()){
                userList.add(DBCursor.getUser());
                DBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return userList;
    }

    public void deleteAllUser()
    {
        db.delete(DBSchema.userTable.NAME, null, null);
    }

    public void addOrderHistory(OrderHistory oH){
        ContentValues cv = new ContentValues();
        cv.put(DBSchema.orderHistoryTable.Cols.ID, oH.getUserId());
        cv.put(DBSchema.orderHistoryTable.Cols.ITEMS, oH.getItems());
        cv.put(DBSchema.orderHistoryTable.Cols.DATE, oH.getDate());
        cv.put(DBSchema.orderHistoryTable.Cols.RESTNAME, oH.getRestaurantName());
        cv.put(DBSchema.orderHistoryTable.Cols.COST, oH.getCost());
        db.insert(DBSchema.orderHistoryTable.NAME, null, cv);
    }

    public ArrayList<OrderHistory> getAllOrderHistory(){
        ArrayList<OrderHistory> orderHistoryList = new ArrayList<>();
        Cursor cursor = db.query(DBSchema.orderHistoryTable.NAME,null,null,null,null,null,null);
        DBCursor DBCursor = new DBCursor(cursor);

        try{
            DBCursor.moveToFirst();
            while(!DBCursor.isAfterLast()){
                orderHistoryList.add(DBCursor.getOrderHistory());
                DBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return orderHistoryList;
    }

    public void deleteAllOrderHistory()
    {
        db.delete(DBSchema.orderHistoryTable.NAME, null, null);
    }

    public void addLoggedIn(LoggedIn lI){
        ContentValues cv = new ContentValues();
        cv.put(DBSchema.loggedInTable.Cols.ID, lI.getUserId());
        cv.put(DBSchema.loggedInTable.Cols.NAME, lI.getName());
        db.insert(DBSchema.loggedInTable.NAME, null, cv);
    }

    public ArrayList<LoggedIn> getAllLoggedIn(){
        ArrayList<LoggedIn> LoggedInList = new ArrayList<>();
        Cursor cursor = db.query(DBSchema.loggedInTable.NAME,null,null,null,null,null,null);
        DBCursor DBCursor = new DBCursor(cursor);

        try{
            DBCursor.moveToFirst();
            while(!DBCursor.isAfterLast()){
                LoggedInList.add(DBCursor.getLoggedIn());
                DBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return LoggedInList;
    }

    public void deleteAllLoggedIn()
    {
        db.delete(DBSchema.loggedInTable.NAME, null, null);
    }
}
