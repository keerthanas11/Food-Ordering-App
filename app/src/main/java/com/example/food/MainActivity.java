package com.example.food;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TabLayout tabLayout;
    TextView cartIcon;
    List<FoodItem> southIndianList;
    List<FoodItem> northIndianList;
    List<FoodItem> juicesList;
    List<FoodItem> italianList;
    List<FoodItem> continentalList;

    List<FoodItem> cartList = new ArrayList<>(); // Global cart list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        tabLayout = findViewById(R.id.tabLayout);
        cartIcon = findViewById(R.id.cartIcon);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize Tabs
        tabLayout.addTab(tabLayout.newTab().setText("South Indian"));
        tabLayout.addTab(tabLayout.newTab().setText("North Indian"));
        tabLayout.addTab(tabLayout.newTab().setText("Juices"));
        tabLayout.addTab(tabLayout.newTab().setText("Italian"));
        tabLayout.addTab(tabLayout.newTab().setText("Continental"));

        initializeFoodLists();

        // Set Default Tab
        recyclerView.setAdapter(new FoodAdapter(MainActivity.this, southIndianList, cartList));

        // Tab Change Listener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                List<FoodItem> selectedList;
                switch (position) {
                    case 0:
                        selectedList = southIndianList;
                        break;
                    case 1:
                        selectedList = northIndianList;
                        break;
                    case 2:
                        selectedList = juicesList;
                        break;
                    case 3:
                        selectedList = italianList;
                        break;
                    case 4:
                        selectedList = continentalList;
                        break;
                    default:
                        selectedList = southIndianList;
                }


                recyclerView.setAdapter(new FoodAdapter(MainActivity.this, selectedList, cartList));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        // Cart Icon Click
        cartIcon.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, cart.class);
            intent.putExtra("cartItems", new ArrayList<>(cartList)); // Pass cart list
            startActivity(intent);
        });



    }
        // Initialize Food Lists
    private void initializeFoodLists() {
        southIndianList = new ArrayList<>();
        southIndianList.add(new FoodItem(R.drawable.dosa, "Dosa", "80"));
        southIndianList.add(new FoodItem(R.drawable.idli, "Idli", "40"));
        southIndianList.add(new FoodItem(R.drawable.vada, "Vada", "30"));
        southIndianList.add(new FoodItem(R.drawable.upma, "Upma", "60"));
        southIndianList.add(new FoodItem(R.drawable.pongal, "Pongal", "70"));
        southIndianList.add(new FoodItem(R.drawable.rice, "Rasam Rice", "80"));
        southIndianList.add(new FoodItem(R.drawable.bb, "Bisi Bele Bath", "90"));

        northIndianList = new ArrayList<>();
        northIndianList.add(new FoodItem(R.drawable.paratha, "Paratha", "120"));
        northIndianList.add(new FoodItem(R.drawable.rajma_chawal, "Rajma Chawal", "150"));
        northIndianList.add(new FoodItem(R.drawable.c, "Chole Bhature", "120"));
        northIndianList.add(new FoodItem(R.drawable.p, "Paneer Tikka", "180"));
        northIndianList.add(new FoodItem(R.drawable.d, "Dal Makhani", "140"));
        northIndianList.add(new FoodItem(R.drawable.k, "Amritsari Kulcha", "100"));

        juicesList = new ArrayList<>();
        juicesList.add(new FoodItem(R.drawable.orange_juice, "Orange Juice", "50"));
        juicesList.add(new FoodItem(R.drawable.mango_shake, "Mango Shake", "60"));
        juicesList.add(new FoodItem(R.drawable.a, "Apple Juice", "70"));
        juicesList.add(new FoodItem(R.drawable.w, "Watermelon Juice", "50"));
        juicesList.add(new FoodItem(R.drawable.pj, "Pineapple Juice", "60"));
        //juicesList.add(new FoodItem(R.drawable.carrot_juice, "Carrot Juice", "₹55"));
        juicesList.add(new FoodItem(R.drawable.pom, "Pomegranate Juice", "80"));

        italianList = new ArrayList<>();
        italianList.add(new FoodItem(R.drawable.food1, "Pizza", "299"));
        italianList.add(new FoodItem(R.drawable.food3, "Pasta", "249"));
        italianList.add(new FoodItem(R.drawable.ris, "Risotto", "280"));
        italianList.add(new FoodItem(R.drawable.gb, "Garlic Bread", "150"));
        italianList.add(new FoodItem(R.drawable.l, "Lasagna", "320"));
        italianList.add(new FoodItem(R.drawable.t, "Tiramisu", "200"));
        italianList.add(new FoodItem(R.drawable.br, "Bruschetta", "180"));

        continentalList = new ArrayList<>();
        continentalList.add(new FoodItem(R.drawable.food2, "Burger", "199"));
        continentalList.add(new FoodItem(R.drawable.sandwich, "Sandwich", "150"));
        continentalList.add(new FoodItem(R.drawable.gc, "Grilled Chicken", "300"));
        continentalList.add(new FoodItem(R.drawable.mc, "Mac and Cheese", "250"));
        continentalList.add(new FoodItem(R.drawable.cs, "Caesar Salad", "180"));
        continentalList.add(new FoodItem(R.drawable.cr ,"Creamy Soup", "120"));
        continentalList.add(new FoodItem(R.drawable.s, "Steak", "350"));


    }
}
