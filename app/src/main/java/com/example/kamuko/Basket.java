package com.example.kamuko;

import java.util.ArrayList;

public class Basket
{
    public static ArrayList<Cart> cart;

    public Basket()
    {
        cart = new ArrayList<>();
    }

    public void addCart(Cart item)
    {
        cart.add(item);
    }

    public void removeItem(Cart item)
    {
        cart.remove(item);
    }

    public void removeAllItems(){cart.clear();}

    public ArrayList<Cart> getCart()
    {
        return cart;
    }
}
