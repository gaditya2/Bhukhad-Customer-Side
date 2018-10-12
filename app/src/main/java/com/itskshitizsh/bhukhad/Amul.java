package com.itskshitizsh.bhukhad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;

public class Amul extends AppCompatActivity {
    Item[] items_amul_parlour_items =

            {
                    new Item("Kadi Kachori(1pcs)", 15.0, 1
                    ),
                    new Item("Poha(1plate)", 20.0, 1
                    ),
                    new Item("Veg Sprouts(1plate)", 20.0, 1
                    ),
                    new Item("Idli(2pcs)", 20.0, 1
                    ),
                    new Item("Utthpam(1pcs)", 35.0, 1
                    ),
                    new Item("Upma(1plate)", 20.0, 1
                    ),
                    new Item("Samosa(1pcs)", 10.0, 1
                    ),
                    new Item("Pav Bhaji(1plate)", 30.0, 1
                    ),
                    new Item("Vada Pav(1pcs)", 15.0, 1
                    ),
                    new Item("Burger Cheese", 30.0, 1
                    ),
                    new Item("Sevaya Upma(1plate)", 20.0, 1
                    ),
                    new Item("Pasta(1plate)", 40.0, 1
                    ),
                    new Item("Paneer Dosa", 60.0, 1
                    ),
                    new Item("Masala Dosa", 40.0, 1
                    ),
                    new Item("Plain Dosa", 30.0, 1
                    ),
                    new Item("Crispy Potato", 40.0, 1
                    ),
                    new Item("Chilli Potato", 40.0, 1
                    ),
                    new Item("Chilli Paneer", 60.0, 1
                    ),
                    new Item("French Fries", 25.0, 1
                    ),
                    new Item("Manchurian", 40.0, 1
                    ),
                    new Item("Fried Rice", 30.0, 1
                    ),
                    new Item("Manchurian with Fried Rice", 60.0, 1
                    ),
                    new Item("Veg Roll", 20.0, 1
                    ),
                    new Item("Egg Roll", 30.0, 1
                    ),
                    new Item("Double Egg Roll", 45.0, 1
                    ),
                    new Item("Paneer Roll", 40.0, 1
                    ),
                    new Item("Aloo Pyaz Paratha", 25.0, 1
                    ),
                    new Item("Lachcha Paratha", 15.0, 1
                    ),
                    new Item("Veg Paratha", 25.0, 1
                    ),
                    new Item("Paneer Paratha", 25.0, 1
                    ),
                    new Item("Aloo Paratha", 20.0, 1
                    ),
                    new Item("Egg Paratha", 30.0, 1
                    ),
                    new Item("Egg Omelet", 15.0, 1
                    ),
                    new Item("Double Egg Omelet", 25.0, 1
                    ),
                    new Item("One Egg Bhurji", 15.0, 1
                    ),
                    new Item("Double Egg Bhurji", 25.0, 1
                    ),
                    new Item("One Boiled Egg", 10.0, 1
                    ),
                    new Item("Maggi Plain", 40.0, 1
                    ),
                    new Item("Paneer Maggie", 30.0, 1
                    ),
                    new Item("Veg Maggie", 40.0, 1
                    ),
                    new Item("Cheese Maggie", 30.0, 1
                    ),
                    new Item("Double Egg Curry", 40.0, 1
                    ),
                    new Item("Paneer Butter Masala", 30.0, 1
                    ),
                    new Item("Swiss Roll", 40.0, 1
                    ),
                    new Item("Bread Poha", 30.0, 1
                    ),
                    new Item("Kullad Lassi", 40.0, 1
                    ),
                    new Item("Sev Tamatar", 30.0, 1
                    ),
                    new Item("Single Egg Bhurji Maggi", 40.0, 1
                    ),
                    new Item("Momos", 30.0, 1
                    ),
                    new Item("Chaumin", 40.0, 1
                    ),
                    new Item("Egg Chaumin", 30.0, 1
                    ),
                    new Item("Paneer Chaumin", 40.0, 1
                    ),
                    new Item("Aloo Patties", 30.0, 1
                    ),
                    new Item("Aloo Masala Patties", 30.0, 1
                    ),
                    new Item("Paneer Patties", 30.0, 1
                    ),
                    new Item("Paneer Masala Patties", 30.0, 1
                    ),
                    new Item("Tandoori Patties", 30.0, 1
                    ),
                    new Item("Cheese Patties", 30.0, 1
                    ),
                    new Item("Cream Roll", 30.0, 1
                    ),
                    new Item("Cream Roll Chocolate", 30.0, 1
                    ),
                    new Item("Muffins", 30.0, 1
                    ),
                    new Item("Chocolava", 30.0, 1
                    ),
                    new Item("Donought", 30.0, 1
                    ),
                    new Item("Brownies", 30.0, 1
                    ),
                    new Item("Wheat Cake", 30.0, 1
                    ),
                    new Item("Veg Burger", 30.0, 1
                    ),
                    new Item("Cheese Burger", 40.0, 1
                    ),
                    new Item("Cheese Sandwitch", 30.0, 1
                    ),
                    new Item("Cheese Veg Sandwitch", 30.0, 1
                    ),
                    new Item("Paneer Tikka Sandwitch", 40.0, 1
                    ),
                    new Item("Pizza", 50.0, 1
                    ),
                    new Item("Cappaccino", 20.0, 1
                    ),
                    new Item("Cafe Latte", 20.0, 1
                    ),
                    new Item("Espresso", 30.0, 1
                    ),
                    new Item("Hot Chocolate", 20.0, 1
                    ),
                    new Item("Hot MIlk", 20.0, 1
                    ),
                    new Item("Tea", 10.0, 1
                    )};
    private RecyclerView listView;
    private MenuAdapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amul);
        listView = findViewById(R.id.amulMenu);
        RecyclerView.LayoutManager ol = new LinearLayoutManager(getApplicationContext());
        listView.setLayoutManager(ol);
        menuAdapter = new MenuAdapter(this, Arrays.asList(items_amul_parlour_items));
        listView.setAdapter(menuAdapter);

    }
}
