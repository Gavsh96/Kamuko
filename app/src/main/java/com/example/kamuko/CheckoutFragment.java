package com.example.kamuko;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class CheckoutFragment extends Fragment {

    private DBModel rDBm;
    private ArrayList<LoggedIn> lI;
    private ArrayList<Restaurant> rest;
    private ArrayList<Menu> menu;
    private Iterator<Cart> itU;
    private Iterator<Restaurant> it;
    private Iterator<Menu> it2;
    private ArrayList<Cart> list;
    private Calendar c = Calendar.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkout, container, false);

        rDBm = new DBModel();
        rDBm.load(getActivity().getApplicationContext());
        lI = rDBm.getAllLoggedIn();
        rest = rDBm.getAllRestaurant();
        menu = rDBm.getAllMenu();
        list = MainActivity.theCart.getCart();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sdf.format(c.getTime());

        OrderHistory oH  = new OrderHistory(lI.get(0).getUserId(),makeString(),strDate,getRestname(), TotalCost());
        rDBm.addOrderHistory(oH);

        return view;
    }

    private String makeString()
    {
        String items = "";
        itU = list.iterator();

        while (itU.hasNext())
        {
            Cart cItems = itU.next();
            items = items +" "+ cItems.getCount() +" "+ cItems.getMenuName() +" "+ cItems.getPrice();
        }

        return items;
    }

    private Double TotalCost()
    {
        double cost = 0;
        itU = list.iterator();

        while (itU.hasNext())
        {
            Cart cItems = itU.next();
            cost = cost + cItems.getPrice();
        }

        return cost;
    }

    private String getRestname()
    {
        String cId = list.get(0).getId();
        String RestId = searchMenu(cId);

        return searchName(RestId);
    }

    private String searchMenu(String menId)
    {
        it2 = menu.iterator();

        while (it2.hasNext())
        {
            Menu men = it2.next();
            if(men.getId().equals(menId))
            {
                return men.getRestId();
            }
        }
        return null;
    }

    private String searchName(String nameId)
    {
        it = rest.iterator();

        while (it.hasNext())
        {
            Restaurant rest = it.next();
            if(rest.getId().equals(nameId))
            {
                return rest.getName();
            }
        }
        return null;
    }
}