package com.example.kamuko;

import android.content.Intent;
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
 * Use the {@link SpecialMenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SpecialMenuFragment extends Fragment implements SpecialMenuInterface{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private DBModel dbModel;

    public SpecialMenuFragment() {
        // Required empty public constructor
    }

    public SpecialMenuFragment(DBModel dbModel)
    {
        this.dbModel = dbModel;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SpecialMenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SpecialMenuFragment newInstance(String param1, String param2) {
        SpecialMenuFragment fragment = new SpecialMenuFragment();
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
        View v = inflater.inflate(R.layout.fragment_special_menu, container, false);

        RecyclerView rv = v.findViewById(R.id.SpecialMenuRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        SpecialMenuAdapter adapter = new SpecialMenuAdapter(dbModel, this);
        rv.setAdapter(adapter);
        return v;
    }

    @Override
    public void onSpecialClick(int position, ArrayList<Menu> list) {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        intent.putExtra("id", list.get(position).getId());
        startActivity(intent);
    }
}