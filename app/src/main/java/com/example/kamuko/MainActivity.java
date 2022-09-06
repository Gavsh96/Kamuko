package com.example.kamuko;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager frag = getSupportFragmentManager();
        SpecialMenuFragment specialMenuFragment = (SpecialMenuFragment) frag.findFragmentById(R.id.frameLayout);
        RestaurantDBModel rDBm = new RestaurantDBModel();
        CreateRestaurants(rDBm);
        specialMenuFragment = new SpecialMenuFragment();
        frag.beginTransaction().add(R.id.frameLayout, specialMenuFragment).commit();
    }

    private void CreateRestaurants(RestaurantDBModel rDBm)
    {
        Restaurant r1 = new Restaurant("1234", "Shamika's Chicken Shop", "kukula");
        Restaurant r2 = new Restaurant("1235", "Akbho Bell", "taco");
        Restaurant r3 = new Restaurant("1236", "Gav's Pizza", "pizza");
        Restaurant r4 = new Restaurant("1237", "Hindiye kade", "roti");
        Restaurant r5 = new Restaurant("1238", "Beepan plaintea", "tea");

        rDBm.addRestaurant(r1);
        rDBm.addRestaurant(r2);
        rDBm.addRestaurant(r3);
        rDBm.addRestaurant(r4);
        rDBm.addRestaurant(r5);
    }
}