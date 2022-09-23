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

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment implements CartInterface{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private DBModel rDBm;
    Button checkoutButton;
    ArrayList<Cart> list;
    ArrayList<LoggedIn> lI;
    private Iterator<Cart> itU;
    Time time = new Time();

    public CartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
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
        View v = inflater.inflate(R.layout.fragment_cart, container, false);

        rDBm = new DBModel();
        rDBm.load(getActivity().getApplicationContext());
        //list = rDBm.getAllCartData();
        lI = rDBm.getAllLoggedIn();
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
                    OrderHistory oH = new OrderHistory(lI.get(0).getUserId(),makeString(),"dsad","sadsdasda","sdasdasda", 55);
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
            items = items +" "+ cItems.getMenuName() +" "+ cItems.getCount();
        }

        return items;
    }
}