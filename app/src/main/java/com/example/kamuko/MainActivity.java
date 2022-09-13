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
        //Creating Restaurants
        Restaurant r1 = new Restaurant("1234", "Shamika's Chicken Shop", R.drawable.restaurant);

        Restaurant r2 = new Restaurant("1235", "Posh By Akbho", R.drawable.restaurant);
        Menu r2m1 = new Menu("01", "Posh Fries", R.drawable.profile, r2.getId());
        Menu r2m2 = new Menu("02", "Chicken Posh Burger", R.drawable.profile, r2.getId());
        Menu r2m3 = new Menu("03", "Spicy Beef Burger", R.drawable.profile, r2.getId());
        Menu r2m4 = new Menu("04", "Nai Miris Pork Posh Burger", R.drawable.profile, r2.getId());
        Menu r2m5 = new Menu("05", "Gon Wada Special", R.drawable.profile, r2.getId());

        Restaurant r3 = new Restaurant("1236", "Gav's Pizza", R.drawable.restaurant);
        Menu r3m1 = new Menu("01", "Cheese Pizza", R.drawable.profile, r3.getId());
        Menu r3m2 = new Menu("02", "Pattah Spicy Beef Pizza", R.drawable.profile, r3.getId());
        Menu r3m3 = new Menu("03", "Lankan Pizza", R.drawable.profile, r3.getId());
        Menu r3m4 = new Menu("04", "Nai Miris Pizza", R.drawable.profile, r3.getId());
        Menu r3m5 = new Menu("05", "Gindara Cake", R.drawable.profile, r3.getId());

        Restaurant r4 = new Restaurant("1237", "Matara Bath kade", R.drawable.matarabathkade);
        Menu r4m1 = new Menu("01", "Chicken Rice & Curry", R.drawable.profile, r4.getId());
        Menu r4m2 = new Menu("02", "Beef Rice & Curry", R.drawable.profile, r4.getId());
        Menu r4m3 = new Menu("03", "Pork Rice & Curry", R.drawable.profile, r4.getId());
        Menu r4m4 = new Menu("04", "Pol Rotti & Chicken Curry", R.drawable.profile, r4.getId());
        Menu r4m5 = new Menu("05", "Pol Rotti & Beef Curry", R.drawable.profile, r4.getId());

        Restaurant r5 = new Restaurant("1238", "KFC", R.drawable.kfcimage);
        Menu r5m1 = new Menu("01", "Fries", R.drawable.profile, r5.getId());
        Menu r5m2 = new Menu("02", "Chicken Burger", R.drawable.profile, r5.getId());
        Menu r5m3 = new Menu("03", "Beef Burger", R.drawable.profile, r5.getId());
        Menu r5m4 = new Menu("04", "Pork Burger", R.drawable.profile, r5.getId());
        Menu r5m5 = new Menu("05", "Mutton Burger", R.drawable.profile, r5.getId());

        rDBm.addRestaurant(r1);
        rDBm.addRestaurant(r2);
        rDBm.addRestaurant(r3);
        rDBm.addRestaurant(r4);
        rDBm.addRestaurant(r5);

        rDBm.addMenu(r2m1);
        rDBm.addMenu(r2m2);
        rDBm.addMenu(r2m3);
        rDBm.addMenu(r2m4);
        rDBm.addMenu(r2m5);

        rDBm.addMenu(r3m1);
        rDBm.addMenu(r3m2);
        rDBm.addMenu(r3m3);
        rDBm.addMenu(r3m4);
        rDBm.addMenu(r3m5);

        rDBm.addMenu(r4m1);
        rDBm.addMenu(r4m2);
        rDBm.addMenu(r4m3);
        rDBm.addMenu(r4m4);
        rDBm.addMenu(r4m5);

        rDBm.addMenu(r5m1);
        rDBm.addMenu(r5m2);
        rDBm.addMenu(r5m3);
        rDBm.addMenu(r5m4);
        rDBm.addMenu(r5m5);
    }
}