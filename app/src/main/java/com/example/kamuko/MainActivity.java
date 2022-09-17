package com.example.kamuko;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView restImage = findViewById(R.id.restImage);

        DBModel rDBm = new DBModel();
        rDBm.load(getApplicationContext());

        rDBm.deleteAllRestaurants();
        rDBm.deleteAllMenu();
        rDBm.removeAllItems();
        CreateRestaurants(rDBm);

        FragmentManager frag = getSupportFragmentManager();
        SpecialMenuFragment specialMenuFragment = (SpecialMenuFragment) frag.findFragmentById(R.id.frameLayout);
        specialMenuFragment = new SpecialMenuFragment(rDBm);
        frag.beginTransaction().add(R.id.frameLayout, specialMenuFragment).commit();

        restImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, RestaurantActivity.class);
                startActivity(intent);
            }
        });
    }

    private void CreateRestaurants(DBModel rDBm)
    {
        //Creating Restaurants
        Restaurant r1 = new Restaurant("1234", "Shamika's Chicken Shop", R.drawable.restaurant);

        Restaurant r2 = new Restaurant("1235", "Posh By Akbho", R.drawable.restaurant);
        Menu r2m1 = new Menu("1", "Posh Fries", R.drawable.profile, r2.getId(), 100.00, "Test");
        Menu r2m2 = new Menu("2", "Chicken Posh Burger", R.drawable.profile, r2.getId(), 100.00, "Test");
        Menu r2m3 = new Menu("3", "Spicy Beef Burger", R.drawable.profile, r2.getId(), 100.00, "Test");
        Menu r2m4 = new Menu("4", "Nai Miris Pork Posh Burger", R.drawable.profile, r2.getId(), 100.00, "Test");
        Menu r2m5 = new Menu("5", "Gon Wada Special", R.drawable.profile, r2.getId(), 100.00, "Test");
        Menu r2m6 = new Menu("6", "Gon Wada Ultra", R.drawable.profile, r2.getId(), 100.00, "Test");

        Restaurant r3 = new Restaurant("1236", "Gav's Pizza", R.drawable.restaurant);
        Menu r3m1 = new Menu("7", "Cheese Pizza", R.drawable.profile, r3.getId(), 100.00, "Test");
        Menu r3m2 = new Menu("8", "Pattah Spicy Beef Pizza", R.drawable.profile, r3.getId(), 100.00, "Test");
        Menu r3m3 = new Menu("9", "Lankan Pizza", R.drawable.profile, r3.getId(), 100.00, "Test");
        Menu r3m4 = new Menu("10", "Nai Miris Pizza", R.drawable.profile, r3.getId(), 100.00, "Test");
        Menu r3m5 = new Menu("11", "Gindara Cake", R.drawable.profile, r3.getId(), 100.00, "Test");
        Menu r3m6 = new Menu("12", "Seethala Cake", R.drawable.profile, r3.getId(), 100.00, "Test");

        Restaurant r4 = new Restaurant("1237", "Matara Bath kade", R.drawable.matarabathkade);
        Menu r4m1 = new Menu("13", "Chicken Rice & Curry", R.drawable.matarachickenrice, r4.getId(), 100.00, "Test");
        Menu r4m2 = new Menu("14", "Chicken Fried Rice", R.drawable.matarafried, r4.getId(), 100.00, "Test");
        Menu r4m3 = new Menu("15", "Pork Noodles", R.drawable.mataranoodles, r4.getId(), 100.00, "Test");
        Menu r4m4 = new Menu("16", "Pol Rotti & Chicken Curry", R.drawable.matararotti, r4.getId(), 100.00, "Test");
        Menu r4m5 = new Menu("17", "Egg Hoppers", R.drawable.matarahopper, r4.getId(), 100.00, "Test");
        Menu r4m6 = new Menu("18", "String Hoppers", R.drawable.matarastring, r4.getId(), 100.00, "Test");

        Restaurant r5 = new Restaurant("1238", "KFC", R.drawable.kfcimage);
        Menu r5m1 = new Menu("19", "Fries", R.drawable.kfcfries, r5.getId(), 100.00, "Test");
        Menu r5m2 = new Menu("20", "Chicken Burger", R.drawable.kfczinger, r5.getId(), 100.00, "Test");
        Menu r5m3 = new Menu("21", "Beef Burger", R.drawable.kfcbeef, r5.getId(), 100.00, "Test");
        Menu r5m4 = new Menu("22", "Chicken Sawan", R.drawable.kfcsawan, r5.getId(), 100.00, "Test");
        Menu r5m5 = new Menu("23", "Chicken Bucket", R.drawable.kfcbucket, r5.getId(), 100.00, "Test");
        Menu r5m6 = new Menu("24", "KFC Cola Special", R.drawable.kfccola, r5.getId(), 100.00, "Test");

        Restaurant r6 = new Restaurant("1239", "Ichiraku Ramen", R.drawable.ichiraku);
        Menu r6m1 = new Menu("25", "Ramen", R.drawable.ichirakuramen, r6.getId(), 2500.00, "Japanese noodles " +
                "made with the finest wheat flour and alkaline water to add elasticity. Served in a broth with a slice " +
                "of pork and bamboo shoots");
        Menu r6m2 = new Menu("26", "Sushi", R.drawable.ichirakusushi, r6.getId(), 100.00, "Prepared with " +
                "the finest vinegared rice accompanied by raw seafood and vegetables");
        Menu r6m3 = new Menu("27", "Miso Soup", R.drawable.ichirakumiso, r6.getId(), 100.00, "Traditional " +
                "Japanese soup consisting of dashi stock accompanied by tofu and vegetables");
        Menu r6m4 = new Menu("28", "Omu Raisu", R.drawable.ichirakurisu, r6.getId(), 100.00, "An Omelette " +
                "made with fried rice and thin, fried scrambled eggs topped off with ketchup");
        Menu r6m5 = new Menu("29", "Sukiyaki", R.drawable.ichirakusukiyaki, r6.getId(), 100.00, "A Japanese " +
                "hot pot consisting of sliced beef which is slowly cooked alongside vegetables in a mixture of soy sauce and sugar");
        Menu r6m6 = new Menu("30", "Kawaii Mochi", R.drawable.ichirakumochi, r6.getId(), 100.00, "A Japanese " +
                "rice cake made of mochigome, a short grained japonica glutinous rice.");

        Restaurant r7 = new Restaurant("1240", "Seoul Cafe", R.drawable.seoulcafe);
        Menu r7m1 = new Menu("31", "Bibimbap", R.drawable.seoulbibimbap, r7.getId(), 100.00, "Test");
        Menu r7m2 = new Menu("32", "Jjajangmyeon", R.drawable.seouljjajangmyeon, r7.getId(), 100.00, "Test");
        Menu r7m3 = new Menu("33", "Kongguksu", R.drawable.seoulkongguksu, r7.getId(), 100.00, "Test");
        Menu r7m4 = new Menu("34", "Gimbap", R.drawable.seoulgimbap, r7.getId(), 100.00, "Test");
        Menu r7m5 = new Menu("35", "Tteokbokki", R.drawable.seoultteokbokki, r7.getId(), 100.00, "Test");
        Menu r7m6 = new Menu("36", "Jjigae", R.drawable.seouljjigae, r7.getId(), 100.00, "Test");

        rDBm.addRestaurant(r1);
        rDBm.addRestaurant(r2);
        rDBm.addRestaurant(r3);
        rDBm.addRestaurant(r4);
        rDBm.addRestaurant(r5);
        rDBm.addRestaurant(r6);
        rDBm.addRestaurant(r7);

        rDBm.addMenu(r2m1);
        rDBm.addMenu(r2m2);
        rDBm.addMenu(r2m3);
        rDBm.addMenu(r2m4);
        rDBm.addMenu(r2m5);
        rDBm.addMenu(r2m6);

        rDBm.addMenu(r3m1);
        rDBm.addMenu(r3m2);
        rDBm.addMenu(r3m3);
        rDBm.addMenu(r3m4);
        rDBm.addMenu(r3m5);
        rDBm.addMenu(r3m6);

        rDBm.addMenu(r4m1);
        rDBm.addMenu(r4m2);
        rDBm.addMenu(r4m3);
        rDBm.addMenu(r4m4);
        rDBm.addMenu(r4m5);
        rDBm.addMenu(r4m6);

        rDBm.addMenu(r5m1);
        rDBm.addMenu(r5m2);
        rDBm.addMenu(r5m3);
        rDBm.addMenu(r5m4);
        rDBm.addMenu(r5m5);
        rDBm.addMenu(r5m6);

        rDBm.addMenu(r6m1);
        rDBm.addMenu(r6m2);
        rDBm.addMenu(r6m3);
        rDBm.addMenu(r6m4);
        rDBm.addMenu(r6m5);
        rDBm.addMenu(r6m6);

        rDBm.addMenu(r7m1);
        rDBm.addMenu(r7m2);
        rDBm.addMenu(r7m3);
        rDBm.addMenu(r7m4);
        rDBm.addMenu(r7m5);
        rDBm.addMenu(r7m6);
    }
}