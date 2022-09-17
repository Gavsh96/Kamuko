package com.example.kamuko;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

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
    int pos;
    int count;

    public MenuDescFragment() {
        // Required empty public constructor
    }

    public MenuDescFragment(DBModel rDBm)
    {
        this.rDBm = rDBm;
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

        img = v.findViewById(R.id.menuImage);
        text = v.findViewById(R.id.menuText);
        price = v.findViewById(R.id.price);
        addButton = v.findViewById(R.id.plusButton);
        subButton = v.findViewById(R.id.minusButton);
        countView = v.findViewById(R.id.quantity);

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

        return v;
    }
}