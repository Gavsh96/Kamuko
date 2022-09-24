package com.example.kamuko;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static Basket theCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView restImage = findViewById(R.id.restImage);
        ImageView loginImage = findViewById(R.id.loginImage);
        theCart = new Basket();

        DBModel rDBm = new DBModel();
        rDBm.load(getApplicationContext());

        rDBm.deleteAllRestaurants();
        rDBm.deleteAllMenu();
        rDBm.removeAllItems();
        rDBm.deleteAllUser();
        CreateRestaurants(rDBm);

        FragmentManager frag = getSupportFragmentManager();
        SpecialMenuFragment specialMenuFragment = (SpecialMenuFragment) frag.findFragmentById(R.id.frameLayout);
        specialMenuFragment = new SpecialMenuFragment();
        frag.beginTransaction().add(R.id.frameLayout, specialMenuFragment).commit();

        restImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RestaurantActivity.class);
                startActivity(intent);
            }
        });

        loginImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void CreateRestaurants(DBModel rDBm)
    {
        //Creating Restaurants
        Restaurant r1 = new Restaurant("1234", "Shamika's Chicken Shop", R.drawable.restaurant);
        Menu r1m1 = new Menu("1", "Spicy Chicken Wings", R.drawable.sscw, r1.getId(), 1555.00, "Authentic Texas Chicken Wings");
        Menu r1m2 = new Menu("2", "Crispy Chicken", R.drawable.cc, r1.getId(), 1500.00, "Batter fried chicken");
        Menu r1m3 = new Menu("3", "Shamika Special", R.drawable.shamikas, r1.getId(), 3000.00, "Chicken Burger with Shamika's Spicy sauce");
        Menu r1m4 = new Menu("4", "Nai Miris Chicken Wings", R.drawable.naicw, r1.getId(), 2650.00, "Ultra Pro Max Spicy Chicken Wings");
        Menu r1m5 = new Menu("5", "Orange Juice", R.drawable.oj, r1.getId(), 250.00, "Fresh orange juice");
        Menu r1m6 = new Menu("6", "Fruit Salad", R.drawable.fs, r1.getId(), 255.00, "Fresh fruit salad");


        Restaurant r2 = new Restaurant("1235", "Posh Akbho's", R.drawable.poshakbo);
        Menu r2m1 = new Menu("1", "Posh Fries", R.drawable.chickenfries, r2.getId(), 1235.00, "Salted Fires with Chicken");
        Menu r2m2 = new Menu("2", "Chicken Posh Burger", R.drawable.akbhocb, r2.getId(), 6000.00, "Chicken Burger made with the finest ingredients");
        Menu r2m3 = new Menu("3", "Spicy Beef Burger", R.drawable.akbhobb, r2.getId(), 2200.00, "Beef Burger with Akbho's Spicy sauce");
        Menu r2m4 = new Menu("4", "Nai Miris Pork Posh Burger", R.drawable.naib, r2.getId(), 2550.00, "Ultra Pro Max Spicy Pork Burger");
        Menu r2m5 = new Menu("5", "Gon Wada Special", R.drawable.gws, r2.getId(), 2500.00, "Fired Rice with Akbho's favorite ingredients");
        Menu r2m6 = new Menu("6", "Gon Wada Ultra", R.drawable.gwu, r2.getId(), 2555.00, "Fired Noodles with Akbho's favorite ingredients");

        Restaurant r3 = new Restaurant("1236", "Gav's Pizza", R.drawable.gavpizza);
        Menu r3m1 = new Menu("7", "Cheese Pizza", R.drawable.cp, r3.getId(), 1550.00, "Authentic italian cheese pizza");
        Menu r3m2 = new Menu("8", "Pattah Spicy Beef Pizza", R.drawable.bp, r3.getId(), 2220.00, "Pizza with large pieces of beef and a spicy sauce");
        Menu r3m3 = new Menu("9", "Lankan Pizza", R.drawable.slp, r3.getId(), 2100.00, "Pizza with a Sri Lankan twist");
        Menu r3m4 = new Menu("10", "Nai Miris Pizza", R.drawable.sp, r3.getId(), 2100.00, "A super spicy pizza");
        Menu r3m5 = new Menu("11", "Gindara Cake", R.drawable.gc, r3.getId(), 350.00, "10 times more better than your normal lava cake");
        Menu r3m6 = new Menu("12", "Seethala Cake", R.drawable.sc, r3.getId(), 350.00, "Eat this is you wanna chill");

        Restaurant r4 = new Restaurant("1237", "Matara Bath kade", R.drawable.matarabathkade);
        Menu r4m1 = new Menu("13", "Chicken Rice & Curry", R.drawable.matarachickenrice, r4.getId(), 100.00, "Test");
        Menu r4m2 = new Menu("14", "Chicken Fried Rice", R.drawable.matarafried, r4.getId(), 100.00, "Test");
        Menu r4m3 = new Menu("15", "Pork Noodles", R.drawable.mataranoodles, r4.getId(), 100.00, "Test");
        Menu r4m4 = new Menu("16", "Pol Rotti & Chicken Curry", R.drawable.matararotti, r4.getId(), 100.00, "Test");
        Menu r4m5 = new Menu("17", "Egg Hoppers", R.drawable.matarahopper, r4.getId(), 100.00, "Test");
        Menu r4m6 = new Menu("18", "String Hoppers", R.drawable.matarastring, r4.getId(), 100.00, "Test");

        Restaurant r5 = new Restaurant("1238", "KFC", R.drawable.kfcimage);
        Menu r5m1 = new Menu("19", "Fries", R.drawable.kfcfries, r5.getId(), 500.00, "Fresh;y picked potatoes " +
                "cut and dipped in a flavourful batter and fried to crispy perfection");
        Menu r5m2 = new Menu("20", "Chicken Burger", R.drawable.kfczinger, r5.getId(), 1500.00, "A flavourful " +
                "burger bun filled with skinless chicken breast dipped in a batter and fired");
        Menu r5m3 = new Menu("21", "Beef Burger", R.drawable.kfcbeef, r5.getId(), 1650.00, "A burger bun " +
                "that's beef instead of chicken");
        Menu r5m4 = new Menu("22", "Chicken Sawan", R.drawable.kfcsawan, r5.getId(), 3000.00, "A chicken Sawan " +
                "topped with our own gravy and fried chicken. Serves 4 people!");
        Menu r5m5 = new Menu("23", "Chicken Bucket", R.drawable.kfcbucket, r5.getId(), 2000.00, "Handpicked " +
                "skinless chicken drumsticks fried in a batter with six different dipping sauces");
        Menu r5m6 = new Menu("24", "KFC Cola Special", R.drawable.kfccola, r5.getId(), 100.00, "The best " +
                "Coca Cola you will ever taste. Although mostly filled with ice than cola");

        Restaurant r6 = new Restaurant("1239", "Ichiraku Ramen", R.drawable.ichiraku);
        Menu r6m1 = new Menu("25", "Ramen", R.drawable.ichirakuramen, r6.getId(), 2500.00, "Japanese noodles " +
                "made with the finest wheat flour and alkaline water to add elasticity. Served in a broth with a slice " +
                "of pork and bamboo shoots");
        Menu r6m2 = new Menu("26", "Sushi", R.drawable.ichirakusushi, r6.getId(), 5000.00, "Prepared with " +
                "the finest vinegared rice accompanied by raw seafood and vegetables");
        Menu r6m3 = new Menu("27", "Miso Soup", R.drawable.ichirakumiso, r6.getId(), 1250.00, "Traditional " +
                "Japanese soup consisting of dashi stock accompanied by tofu and vegetables");
        Menu r6m4 = new Menu("28", "Omu Raisu", R.drawable.ichirakurisu, r6.getId(), 2500.00, "An Omelette " +
                "made with fried rice and thin, fried scrambled eggs topped off with ketchup");
        Menu r6m5 = new Menu("29", "Sukiyaki", R.drawable.ichirakusukiyaki, r6.getId(), 4000.00, "A Japanese " +
                "hot pot consisting of sliced beef which is slowly cooked alongside vegetables in a mixture of soy sauce and sugar");
        Menu r6m6 = new Menu("30", "Kawaii Mochi", R.drawable.ichirakumochi, r6.getId(), 1000.00, "A Japanese " +
                "rice cake made of mochigome, a short grained japonica glutinous rice.");

        Restaurant r7 = new Restaurant("1240", "Danbam Pub", R.drawable.seoulcafe);
        Menu r7m1 = new Menu("31", "Bibimbap", R.drawable.seoulbibimbap, r7.getId(), 2300.00, "A bowl of " +
                "warm white rice topped with seasoned vegetables, kimchi, soy sauce and chilli pepper paste");
        Menu r7m2 = new Menu("32", "Jjajangmyeon", R.drawable.seouljjajangmyeon, r7.getId(), 1500.00, "Korean " +
                "noodle dish topped with thick sauce made of chunjang, diced pork and vegetables");
        Menu r7m3 = new Menu("33", "Kongguksu", R.drawable.seoulkongguksu, r7.getId(), 2000.00, "Korean noodle " +
                "dish served in a cold soy milk broth");
        Menu r7m4 = new Menu("34", "Gimbap", R.drawable.seoulgimbap, r7.getId(), 1750.00, "Cooked rice, vegetables " +
                "and fish that are rolled in dried sheets of seaweed and served in bite sized slices");
        Menu r7m5 = new Menu("35", "Tteokbokki", R.drawable.seoultteokbokki, r7.getId(), 1600.00, "Simmered cylinder " +
                "shaped rice cakes served with boiled eggs and scallions. Seasoned with spicy chilli paste");
        Menu r7m6 = new Menu("36", "Jjigae", R.drawable.seouljjigae, r7.getId(), 2200.00, "Korean stew made with " +
                "meat in a broth seasoned with chilli paste, soy bean paste and soy sauce");

        Restaurant r8 = new Restaurant("1241", "Hotel De Pilawoos", R.drawable.restaurant);
        Menu r8m1 = new Menu("37", "Cheese Kotthu", R.drawable.profile, r8.getId(), 1100.00, "Test");
        Menu r8m2 = new Menu("38", "Fried Beef Kotthu", R.drawable.profile, r8.getId(), 1250.00, "Test");
        Menu r8m3 = new Menu("39", "Egg Rotti", R.drawable.profile, r8.getId(), 660.00, "Test");
        Menu r8m4 = new Menu("40", "Chicken Curry", R.drawable.profile, r8.getId(), 550.00, "Test");
        Menu r8m5 = new Menu("41", "Iced Milo", R.drawable.profile, r8.getId(), 350.00, "Test");
        Menu r8m6 = new Menu("42", "Fruit Cake", R.drawable.profile, r8.getId(), 250.00, "Test");

        Restaurant r9 = new Restaurant("1242", "Taj Palace", R.drawable.indianimage);
        Menu r9m1 = new Menu("43", "Samosa", R.drawable.samosa, r9.getId(), 120.00, "Fried Pastry with a savory filling " +
                "including ingredients such as potatoes, onions and peas");
        Menu r9m2 = new Menu("44", "Tandoori Chicken", R.drawable.tandoorichicken, r9.getId(), 800.00, "Chicken marinated " +
                "in yogurt and spices and roasted in a cylindrical clay oven");
        Menu r9m3 = new Menu("45", "Biriyani", R.drawable.biriyani, r9.getId(), 1500.00, "A mixed rice dish made with " +
                "Indian spices and chicken in a clay pot");
        Menu r9m4 = new Menu("46", "Naan Rotti", R.drawable.naan, r9.getId(), 1200.00, "A leavened oven baked faltbread");
        Menu r9m5 = new Menu("47", "Lassi", R.drawable.lassi, r9.getId(), 500.00, "A traditional yogurt based drink which has " +
                "a blend of yogurt, water and spices");
        Menu r9m6 = new Menu("48", "Gulab Jamun", R.drawable.gulabjamun, r9.getId(), 500.00, "A sweet confectionary made " +
                "with milk solids and garnished with dried nuts");

        rDBm.addRestaurant(r1);
        rDBm.addRestaurant(r2);
        rDBm.addRestaurant(r3);
        rDBm.addRestaurant(r4);
        rDBm.addRestaurant(r5);
        rDBm.addRestaurant(r6);
        rDBm.addRestaurant(r7);
        rDBm.addRestaurant(r8);
        rDBm.addRestaurant(r9);

        rDBm.addMenu(r1m1);
        rDBm.addMenu(r1m2);
        rDBm.addMenu(r1m3);
        rDBm.addMenu(r1m4);
        rDBm.addMenu(r1m5);
        rDBm.addMenu(r1m6);

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

        rDBm.addMenu(r8m1);
        rDBm.addMenu(r8m2);
        rDBm.addMenu(r8m3);
        rDBm.addMenu(r8m4);
        rDBm.addMenu(r8m5);
        rDBm.addMenu(r8m6);

        rDBm.addMenu(r9m1);
        rDBm.addMenu(r9m2);
        rDBm.addMenu(r9m3);
        rDBm.addMenu(r9m4);
        rDBm.addMenu(r9m5);
        rDBm.addMenu(r9m6);

        User u1 = new User("1234ga", "ppsmols", "123456");
        rDBm.addUser(u1);
    }
}