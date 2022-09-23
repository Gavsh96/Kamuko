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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cart, container, false);

        rDBm = new DBModel();
        rDBm.load(getActivity().getApplicationContext());
        list = MainActivity.theCart.getCart();
        checkoutButton = v.findViewById(R.id.checkout);

        RecyclerView rv = v.findViewById(R.id.CartRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        CartAdapter adapter = new CartAdapter(rDBm, this);
        rv.setAdapter(adapter);

        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!rDBm.getAllLoggedIn().isEmpty())
                {
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

    @Override
    public void onRemoveClick(int position) {
        MainActivity.theCart.removeItem(list.get(position));
        Fragment fragment = new CartFragment();
        FragmentManager frag = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = frag.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}