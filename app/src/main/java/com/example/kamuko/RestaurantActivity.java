package com.example.kamuko;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity implements RestaurantInterface{

    ArrayList<Restaurant> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        DBModel rDBm = new DBModel();
        rDBm.load(getApplicationContext());
        
        list = rDBm.getAllRestaurant();
        RecyclerView rv = findViewById(R.id.RestaurantRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        RestaurantAdapter adapter = new RestaurantAdapter(rDBm, this);
        rv.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("id", list.get(position).getId());
        startActivity(intent);
    }
}