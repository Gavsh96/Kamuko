package com.example.kamuko;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView restImage = findViewById(R.id.restImage);

        RestaurantDBModel rDBm = new RestaurantDBModel();
        rDBm.load(getApplicationContext());

        rDBm.deleteAllRestaurants();
        rDBm.deleteAllMenu();
        CreateRestaurants(rDBm);
        /*FragmentManager frag = getSupportFragmentManager();
        SpecialMenuFragment specialMenuFragment = (SpecialMenuFragment) frag.findFragmentById(R.id.frameLayout);
        specialMenuFragment = new SpecialMenuFragment(rDBm);
        frag.beginTransaction().add(R.id.frameLayout, specialMenuFragment).commit();*/

        restImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Restaurant r1 = new Restaurant("1234", "Shamika's Chicken Shop", R.drawable.restaurant);
                Restaurant r2 = new Restaurant("1235", "Akbho Bell", R.drawable.restaurant);
                Restaurant r3 = new Restaurant("1236", "Gav's Pizza", R.drawable.restaurant);
                Restaurant r4 = new Restaurant("1237", "Hindiye kade", R.drawable.restaurant);
                Restaurant r5 = new Restaurant("1238", "Beepan plaintea", R.drawable.restaurant);

                ArrayList<Restaurant> list = new ArrayList<>();
                list.add(r1);
                list.add(r2);
                list.add(r3);
                list.add(r4);
                list.add(r5);*/

                Intent intent = new Intent(MainActivity.this, RestaurantActivity.class);
                startActivity(intent);
            }
        });
    }

    private void CreateRestaurants(RestaurantDBModel rDBm)
    {
        Restaurant r1 = new Restaurant("1234", "Shamika's Chicken Shop", R.drawable.restaurant);
        Restaurant r2 = new Restaurant("1235", "Akbho Bell", R.drawable.restaurant);
        Restaurant r3 = new Restaurant("1236", "Gav's Pizza", R.drawable.restaurant);
        Restaurant r4 = new Restaurant("1237", "Matara Bath kade", R.drawable.matarabathkade);
        Restaurant r5 = new Restaurant("1238", "KFC", R.drawable.kfcimage);
        Menu m1 = new Menu("01", "Fries", R.drawable.profile, r5.getId());
        Menu m2 = new Menu("02", "Chicken Burger", R.drawable.profile, r5.getId());
        Menu m3 = new Menu("03", "Beef Burger", R.drawable.profile, r5.getId());
        Menu m4 = new Menu("04", "Pork Burger", R.drawable.profile, r5.getId());
        Menu m5 = new Menu("05", "Mutton Burger", R.drawable.profile, r5.getId());

        rDBm.addRestaurant(r1);
        rDBm.addRestaurant(r2);
        rDBm.addRestaurant(r3);
        rDBm.addRestaurant(r4);
        rDBm.addRestaurant(r5);

        rDBm.addMenu(m1);
        rDBm.addMenu(m2);
        rDBm.addMenu(m3);
        rDBm.addMenu(m4);
        rDBm.addMenu(m5);
    }
}