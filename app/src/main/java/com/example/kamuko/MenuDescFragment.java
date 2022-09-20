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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuDescFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuDescFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private DBModel rDBm;
    ImageView img;
    TextView text;
    TextView price;
    TextView countView;
    Button addButton;
    Button subButton;
    Button buttonCart;
    Button addCart;
    int pos;
    int count;

    public MenuDescFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuDescFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuDescFragment newInstance(String param1, String param2) {
        MenuDescFragment fragment = new MenuDescFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

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
                rDBm.addCartItem(new Cart(allMenu.get(pos).getName(), count, allMenu.get(pos).getPrice()*count));
            }
        });

        buttonCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Cart> cart = rDBm.getAllCartItems();
                if(cart.isEmpty())
                {
                    Fragment fragment = new EmptyCartFragment();
                    FragmentManager frag = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = frag.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                else
                {
                    Fragment fragment = new CartFragment();
                    FragmentManager frag = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = frag.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });
        return v;
    }
}