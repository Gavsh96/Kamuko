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
}
