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
}
