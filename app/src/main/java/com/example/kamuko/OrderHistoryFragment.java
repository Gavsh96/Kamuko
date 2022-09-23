package com.example.kamuko;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class OrderHistoryFragment extends Fragment {

    private DBModel rDBm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_order_history, container, false);

        rDBm = new DBModel();
        rDBm.load(getActivity().getApplicationContext());
        RecyclerView rv = v.findViewById(R.id.OrderHistoryRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        /*OrderHistoryAdapter adapter = new OrderHistoryAdapter(rDBm, this);
        rv.setAdapter(adapter);*/

        return v;
    }
}