package com.example.kamuko;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class RestaurantDBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "restaurants.db";

    public RestaurantDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table "+ RestaurantDBSchema.restaurantTable.NAME+"("+RestaurantDBSchema.restaurantTable.Cols.ID+" Text, "+RestaurantDBSchema.restaurantTable.Cols.NAME+" Text, "+RestaurantDBSchema.restaurantTable.Cols.IMAGE+ " Text);");
        sqLiteDatabase.execSQL("create table "+ RestaurantDBSchema.menuTable.NAME+"("+RestaurantDBSchema.menuTable.Cols.ID+" Text, "+RestaurantDBSchema.menuTable.Cols.NAME+" Text, "+RestaurantDBSchema.menuTable.Cols.IMAGE+" Text, "+RestaurantDBSchema.menuTable.Cols.RESTID+ " Text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
