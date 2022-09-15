package com.example.kamuko;

import android.database.Cursor;
import android.database.CursorWrapper;

public class DBCursor extends CursorWrapper {
    public DBCursor(Cursor cursor) {
        super(cursor);
    }

    public Restaurant getRestaurant(){
        String id = getString(getColumnIndex(DBSchema.restaurantTable.Cols.ID));
        String name = getString(getColumnIndex(DBSchema.restaurantTable.Cols.NAME));
        Integer img = getInt(getColumnIndex(DBSchema.restaurantTable.Cols.IMAGE));
        return new Restaurant(id, name, img);
    }

    public Menu getMenu()
    {
        String id = getString(getColumnIndex(DBSchema.menuTable.Cols.ID));
        String name = getString(getColumnIndex(DBSchema.menuTable.Cols.NAME));
        Integer img = getInt(getColumnIndex(DBSchema.menuTable.Cols.IMAGE));
        String restId = getString(getColumnIndex(DBSchema.menuTable.Cols.RESTID));
        return new Menu(id, name, img, restId);
    }

    public User getUser()
    {
        String userId = getString(getColumnIndex(DBSchema.userTable.Cols.ID));
        String name = getString(getColumnIndex(DBSchema.userTable.Cols.NAME));
        String password = getString(getColumnIndex(DBSchema.userTable.Cols.PASSWORD));
        return  new User(userId, name, password);
    }

    public OrderHistory getOrderHistory()
    {
        String userId = getString(getColumnIndex(DBSchema.orderHistoryTable.Cols.ID));
        String items = getString(getColumnIndex(DBSchema.orderHistoryTable.Cols.ITEMS));
        String date = getString(getColumnIndex(DBSchema.orderHistoryTable.Cols.DATE));
        String time = getString(getColumnIndex(DBSchema.orderHistoryTable.Cols.TIME));
        String restaurantName = getString(getColumnIndex(DBSchema.orderHistoryTable.Cols.RESTNAME));
        Integer cost = getInt(getColumnIndex(DBSchema.orderHistoryTable.Cols.COST));
        return  new OrderHistory(userId,items,date,time,restaurantName,cost);
    }

    public LoggedIn getLoggedIn()
    {
        String userId = getString(getColumnIndex(DBSchema.loggedInTable.Cols.ID));
        String name = getString(getColumnIndex(DBSchema.loggedInTable.Cols.NAME));
        return  new LoggedIn(userId, name);
    }
}
