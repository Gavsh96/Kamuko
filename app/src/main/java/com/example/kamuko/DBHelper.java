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
        sqLiteDatabase.execSQL("create table "+ DBSchema.menuTable.NAME+"("+ DBSchema.menuTable.Cols.ID+" Text, "+ DBSchema.menuTable.Cols.NAME+" Text, "+ DBSchema.menuTable.Cols.IMAGE+" Text, "+ DBSchema.menuTable.Cols.RESTID+" Text, "+ DBSchema.menuTable.Cols.PRICE+" Text, "+DBSchema.menuTable.Cols.DESCRIPTION+ " Text);");
        sqLiteDatabase.execSQL("create table "+ DBSchema.userTable.NAME+"("+ DBSchema.userTable.Cols.ID+" Text, "+ DBSchema.userTable.Cols.NAME+" Text, "+ DBSchema.userTable.Cols.PASSWORD+" Text);");
        sqLiteDatabase.execSQL("create table "+ DBSchema.orderHistoryTable.NAME+"("+ DBSchema.orderHistoryTable.Cols.ID+" Text, "+ DBSchema.orderHistoryTable.Cols.ITEMS+" Text, "+ DBSchema.orderHistoryTable.Cols.DATE+" Text, "+ DBSchema.orderHistoryTable.Cols.TIME+ " Text, "+ DBSchema.orderHistoryTable.Cols.RESTNAME+" Text, "+ DBSchema.orderHistoryTable.Cols.COST+" Text);");
        sqLiteDatabase.execSQL("create table "+ DBSchema.loggedInTable.NAME+"("+ DBSchema.loggedInTable.Cols.ID+" Text, "+ DBSchema.loggedInTable.Cols.NAME+" Text);");
        sqLiteDatabase.execSQL("create table "+ DBSchema.cartTable.NAME+"("+ DBSchema.cartTable.Cols.ID+" Text, "+ DBSchema.cartTable.Cols.MENUNAME+" Text, "+DBSchema.cartTable.Cols.COUNT+" Text, "+ DBSchema.cartTable.Cols.PRICE+" Text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
