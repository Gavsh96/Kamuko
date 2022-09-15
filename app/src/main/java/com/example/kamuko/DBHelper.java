package com.example.kamuko;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "restaurants.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table "+ DBSchema.restaurantTable.NAME+"("+ DBSchema.restaurantTable.Cols.ID+" Text, "+ DBSchema.restaurantTable.Cols.NAME+" Text, "+ DBSchema.restaurantTable.Cols.IMAGE+ " Text);");
        sqLiteDatabase.execSQL("create table "+ DBSchema.menuTable.NAME+"("+ DBSchema.menuTable.Cols.ID+" Text, "+ DBSchema.menuTable.Cols.NAME+" Text, "+ DBSchema.menuTable.Cols.IMAGE+" Text, "+ DBSchema.menuTable.Cols.RESTID+ " Text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
