package com.example.kamuko;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class CartFragment extends Fragment implements CartInterface{

    private DBModel rDBm;
    Button checkoutButton;
    ArrayList<Cart> list;
    ArrayList<LoggedIn> lI;
    ArrayList<Restaurant> rest;
    ArrayList<Menu> menu;
    private Iterator<Cart> itU;
    private Iterator<Restaurant> it;
    private Iterator<Menu> it2;
    Calendar c = Calendar.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cart, container, false);

        rDBm = new DBModel();
        rDBm.load(getActivity().getApplicationContext());
        //list = rDBm.getAllCartData();
        lI = rDBm.getAllLoggedIn();
        rest = rDBm.getAllRestaurant();
        menu = rDBm.getAllMenu();
        list = MainActivity.theCart.getCart();
        checkoutButton = v.findViewById(R.id.checkout);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sdf.format(c.getTime());

        RecyclerView rv = v.findViewById(R.id.CartRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        CartAdapter adapter = new CartAdapter(rDBm, this);
        rv.setAdapter(adapter);

        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!rDBm.getAllLoggedIn().isEmpty())
                {
                    OrderHistory oH = new OrderHistory(lI.get(0).getUserId(),makeString(),strDate,getRestname(), TotalCost());
                    rDBm.addOrderHistory(oH);
                    Fragment fragment = new CheckoutFragment();
                    FragmentManager frag = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = frag.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                else
                {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        return v;
    }

    @Override
    public void onCartClick(int position) {
        Fragment fragment = new CartDescFragment();
        Bundle args = new Bundle();
        args.putString("menuID", list.get(position).getId());
        fragment.setArguments(args);
        FragmentManager frag = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = frag.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private String makeString()
    {
        String items = "";
        itU = list.iterator();

        while (itU.hasNext())
        {
            Cart cItems = itU.next();
            items = items +" "+ cItems.getCount() +" "+ cItems.getMenuName();
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