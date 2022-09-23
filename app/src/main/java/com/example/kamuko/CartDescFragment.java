package com.example.kamuko;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartDescFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartDescFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView text;
    TextView countView;
    Button addButton;
    Button subButton;
    Button buttonCart;
    Button addCart;
    ArrayList<Cart> cart;
    int pos;
    int count;

    public CartDescFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CartDescFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CartDescFragment newInstance(String param1, String param2) {
        CartDescFragment fragment = new CartDescFragment();
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
        View v = inflater.inflate(R.layout.fragment_cart_desc, container, false);

        text = v.findViewById(R.id.menuText);
        addButton = v.findViewById(R.id.plusButton);
        subButton = v.findViewById(R.id.minusButton);
        countView = v.findViewById(R.id.quantity);
        buttonCart = v.findViewById(R.id.cartButton);
        addCart = v.findViewById(R.id.addToCart);

        String id = getArguments().getString("menuID");
        cart = MainActivity.theCart.getCart();

        for (int i = 0; i < cart.size(); i++)
        {
            if(cart.get(i).getId().equals(id))
            {
                pos = i;
                count = cart.get(i).getCount();
            }
        }

        try {
            text.setText(cart.get(pos).getMenuName());
        }
        catch(IndexOutOfBoundsException ex)
        {
            Fragment fragment = new CartFragment();
            FragmentManager frag = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = frag.beginTransaction();
            fragmentTransaction.replace(R.id.fragment, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        countView.setText(String.valueOf(count));

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = count +1;
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
                    Cart newItem = new Cart(cart.get(pos).getId(), cart.get(pos).getMenuName(), count, cart.get(pos).getPrice()*count);
                    MainActivity.theCart.addCart(newItem);
                    MainActivity.theCart.removeItem(cart.get(pos));
                }
            }
        });

        buttonCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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