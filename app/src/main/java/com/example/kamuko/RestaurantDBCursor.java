package com.example.kamuko;

import android.database.Cursor;
import android.database.CursorWrapper;

public class RestaurantDBCursor extends CursorWrapper {
    public RestaurantDBCursor(Cursor cursor) {
        super(cursor);
    }

    public Restaurant getRestaurant(){
        String id = getString(getColumnIndex(RestaurantDBSchema.restaurantTable.Cols.ID));
        String name = getString(getColumnIndex(RestaurantDBSchema.restaurantTable.Cols.NAME));
        Integer img = getInt(getColumnIndex(RestaurantDBSchema.restaurantTable.Cols.IMAGE));
        return new Restaurant(id, name, img);
    }

    public Menu getMenu()
    {
        String id = getString(getColumnIndex(RestaurantDBSchema.menuTable.Cols.ID));
        String name = getString(getColumnIndex(RestaurantDBSchema.menuTable.Cols.NAME));
        Integer img = getInt(getColumnIndex(RestaurantDBSchema.menuTable.Cols.IMAGE));
        String restId = getString(getColumnIndex(RestaurantDBSchema.menuTable.Cols.RESTID));
        return new Menu(id, name, img, restId);
    }
}
