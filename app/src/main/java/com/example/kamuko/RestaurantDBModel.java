package com.example.kamuko;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class RestaurantDBModel {

    SQLiteDatabase db;

    public void load(Context context){
        this.db = new RestaurantDBHelper(context).getWritableDatabase();
    }

    public void addRestaurant(Restaurant restaurant){
        ContentValues cv = new ContentValues();
        cv.put(RestaurantDBSchema.restaurantTable.Cols.ID, restaurant.getId());
        cv.put(RestaurantDBSchema.restaurantTable.Cols.NAME, restaurant.getName());
        cv.put(RestaurantDBSchema.restaurantTable.Cols.IMAGE, restaurant.getImg());
        db.insert(RestaurantDBSchema.restaurantTable.NAME, null, cv);
    }

    public ArrayList<Restaurant> getAllRestaurant(){
        ArrayList<Restaurant> studentList = new ArrayList<>();
        Cursor cursor = db.query(RestaurantDBSchema.restaurantTable.NAME,null,null,null,null,null,null);
        RestaurantDBCursor studentDBCursor = new RestaurantDBCursor(cursor);

        try{
            studentDBCursor.moveToFirst();
            while(!studentDBCursor.isAfterLast()){
                studentList.add(studentDBCursor.getRestaurant());
                studentDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return studentList;
    }
}
