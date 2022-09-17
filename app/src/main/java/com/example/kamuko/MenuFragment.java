package com.example.kamuko;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends Fragment implements MenuInterface{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private DBModel rDBm;
    private String id;

    public MenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
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
        View v = inflater.inflate(R.layout.fragment_menu, container, false);

        rDBm = new DBModel();
        rDBm.load(getActivity().getApplicationContext());
        id = getArguments().getString("id");
        RecyclerView rv = v.findViewById(R.id.MenuRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        MenuAdapter adapter = new MenuAdapter(rDBm, id, this);
        rv.setAdapter(adapter);

        return v;
    }

    @Override
    public void onMenuClick(int position) {
        ArrayList<Menu> list = rDBm.getAllMenu();
        ArrayList<Menu> menuList = new ArrayList<>();

        for (Menu menu: list)
        {
            if(menu.getRestId().equals(id))
            {
                menuList.add(menu);
            }
        }

        Fragment fragment = new MenuDescFragment();
        Bundle args = new Bundle();
        args.putString("menuID", menuList.get(position).getId());
        fragment.setArguments(args);
        FragmentManager frag = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = frag.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}