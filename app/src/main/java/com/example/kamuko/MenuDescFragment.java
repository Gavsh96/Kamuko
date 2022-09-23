package com.example.kamuko;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MenuDescFragment extends Fragment {

    private DBModel rDBm;
    ImageView img;
    TextView text;
    TextView price;
    TextView countView;
    Button addButton;
    Button subButton;
    Button buttonCart;
    Button addCart;
    ArrayList<Cart> cart;
    int pos;
    int count;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_menu_desc, container, false);

        rDBm = new DBModel();
        rDBm.load(getActivity().getApplicationContext());

        img = v.findViewById(R.id.menuImage);
        text = v.findViewById(R.id.menuText);
        price = v.findViewById(R.id.price);
        addButton = v.findViewById(R.id.plusButton);
        subButton = v.findViewById(R.id.minusButton);
        countView = v.findViewById(R.id.quantity);
        buttonCart = v.findViewById(R.id.cartButton);
        addCart = v.findViewById(R.id.addToCart);

        String id = getArguments().getString("menuID");
        ArrayList<Menu> allMenu = rDBm.getAllMenu();
        count = 0;
        pos = 0;

        for(int i = 0; i < allMenu.size(); i++)
        {
            if(allMenu.get(i).getId().equals(id))
            {
                pos = i;
            }
        }

        img.setImageResource(allMenu.get(pos).getImg());
        text.setText(allMenu.get(pos).getDescription());
        price.setText(String.valueOf(allMenu.get(pos).getPrice()));
        countView.setText(String.valueOf(count));

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = count + 1;
                countView.setText(String.valueOf(count));
            }
        });

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count > 0)
                {
                    count = count - 1;
                    countView.setText(String.valueOf(count));
                }
            }
        });

        addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count == 0)
                {
                    View av = v.findViewById(R.id.addToCart);
                    Snackbar snackbar = Snackbar.make(av, "Value Zero Not Allowed!", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
                else
                {
                    Cart cItem = new Cart(allMenu.get(pos).getId(), allMenu.get(pos).getName(), count, allMenu.get(pos).getPrice()*count);
                    MainActivity.theCart.addCart(cItem);
                }
            }
        });

        buttonCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cart = MainActivity.theCart.getCart();
                Fragment fragment;
                if(cart.isEmpty())
                {
                    fragment = new EmptyCartFragment();
                }
                else
                {
                    fragment = new CartFragment();
                }
                FragmentManager frag = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = frag.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return v;
    }
}