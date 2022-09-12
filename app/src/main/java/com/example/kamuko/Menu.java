package com.example.kamuko;

import java.util.ArrayList;
import java.util.Iterator;

public class Menu {

    ArrayList<FoodData> menuList;
    Iterator<FoodData> it;
    public Menu()
    {
        menuList = new ArrayList<FoodData>();
    }

    public void addItems(FoodData items)
    {
        menuList.add(items);
    }

    public ArrayList<FoodData> getMenuList()
    {
        return menuList;
    }

    public FoodData searchByName(String name)
    {
      it = menuList.iterator();
      while (it.hasNext())
      {
          FoodData result = it.next();
          if (result.getItemName().equals(name))
          {
              return result;
          }
      }
      return null;
    }
}
