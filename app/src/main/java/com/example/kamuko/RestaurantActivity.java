package com.example.kamuko;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class RestaurantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        DBModel rDBm = new DBModel();
        rDBm.load(getApplicationContext());

        FragmentManager frag = getSupportFragmentManager();
        RestaurantFragment restaurantFragment = (RestaurantFragment) frag.findFragmentById(R.id.fragment);
        restaurantFragment = new RestaurantFragment(rDBm);
        frag.beginTransaction().add(R.id.fragment, restaurantFragment).commit();
    }
}