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
        pos = 0;
        count = 0;

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
                /*ArrayList<Cart> cart = rDBm.getAllCartItems();
                if(!cart.isEmpty())
                {
                    for (Cart item: cart)
                    {
                        if(item.getId().equals(allMenu.get(pos).getId()))
                        {
                            //rDBm.removeCartItem(item);
                            //rDBm.addCartItem(new Cart(allMenu.get(pos).getId(), count));
                            item.setCount(count);
                            Log.d("Item", "Same item repeated therefore count increased. |Count: "+count+" ID : "+item.getId());
                        }
                        else
                        {
                            rDBm.addCartItem(new Cart(allMenu.get(pos).getId(), count));
                            Log.d("Item", "Added new Item to cart |ID: "+allMenu.get(pos).getId()+" Count : "+count);
                        }
                    }
                }
                else
                {
                    rDBm.addCartItem(new Cart(allMenu.get(pos).getId(), count));
                    Log.d("Item", "New Cart item added |Count: "+count+" ID : "+allMenu.get(pos).getId());
                }*/
            }
        });

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = count - 1;
                countView.setText(String.valueOf(count));
            }
        });

        addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cart cItem = new Cart(allMenu.get(pos).getName(), count, allMenu.get(pos).getPrice()*count);
                rDBm.addCartItem(cItem);
                cart = rDBm.getAllCartData();
                text.setText(cart.size());
            }
        });

        buttonCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cart = rDBm.getAllCartData();
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