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
}
