package com.example.kamuko;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        RestaurantDBModel rDBm = new RestaurantDBModel();
        rDBm.load(getApplicationContext());
        
        RecyclerView rv = findViewById(R.id.RestaurantRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        RestaurantAdapter adapter = new RestaurantAdapter(rDBm);
        rv.setAdapter(adapter);
    }
}