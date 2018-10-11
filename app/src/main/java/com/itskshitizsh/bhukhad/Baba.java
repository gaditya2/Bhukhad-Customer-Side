package com.itskshitizsh.bhukhad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;

public class Baba extends AppCompatActivity {
    Item[] items_baba_juice_center_parantha = {
            new Item("Plain Parantha", 15.0, 4),
            new Item("Jeera Parantha", 20.0, 4),
            new Item("Aloo Parantha", 20.0, 4),
            new Item("Pyaz Parantha", 25.0, 4),
            new Item("Aloo_pyaz Parantha", 30.0, 4),
            new Item("Paneer Parantha", 20.0, 4),
    };
    Item[] items_baba_juice_center_Patties = {
            new Item("Aloo Patties", 12.0, 4),
            new Item("Aloo Masala Patties", 15.0, 4),
            new Item("Paneer Patties", 12.0, 4),
            new Item("Cheese Patties", 20.0, 4),
    };
    Item[] items_baba_juice_center_Bhelpuri = {
            new Item("Bhelpuri", 20.0, 4),
    };
    Item[] items_baba_juice_center_Snacks = {

            new Item("Cream Roll", 10.0, 4),
            new Item("Hot Dog", 25.0, 4),
            new Item("Burger", 25.0, 4),
            new Item("Cheese Sandwich", 30.0, 4),
            new Item("Masala Sandwich", 30.0, 4),
            new Item("Pan Piazza", 40.0, 4),
    };
    Item[] items_baba_juice_center_Maggie = {

            new Item("Yipee", 20.0, 4),
            new Item("maggie", 22.0, 4),
            new Item("Veg maggie", 30.0, 4),
            new Item("Butter maggie", 30.0, 4),
            new Item("Cheese maggie", 40.0, 4),
            new Item("veg atta maggie", 40.0, 4),
    };
    Item[] items_baba_juice_center_fruit_plate = {

            new Item("Banana Plate", 10.0, 4),
            new Item("Papaya Plate", 20.0, 4),
            new Item("Pineapple Plate", 20.0, 4),
            new Item("Apple Plate", 30.0, 4),
            new Item("Salad Plate", 30.0, 4),
    };
    Item[] items_baba_juice_center_cackes = {

            new Item("Vanilla", 180.0, 4),
            new Item("Pineapple", 180.0, 4),
            new Item("Strawberry", 180.0, 4),
            new Item("Butterscotch", 250.0, 4),
            new Item("Black Forest", 220.0, 4),
            new Item("Simple Chocolate", 180.0, 4),
            new Item("Dark Chocolate", 250.0, 4),
            new Item("White Forest", 250.0, 4),
            new Item("Choco Crunch", 300.0, 4)

    };
    Item[] items_baba_juice_center_juice = {

            new Item("Gajar", 20.0, 4),
            new Item("Pineapple", 20.0, 4),
            new Item("Orange", 25.0, 4),
            new Item("Mausmi(plain)", 30.0, 4),
            new Item("Mausmi", 30.0, 4),
    };
    Item[] items_baba_juice_center_shakes = {

            new Item("Papita Shake", 20.0, 4),
            new Item("Pineapple Shake", 25.0, 4),
            new Item("Banana Shake", 20.0, 4),
            new Item("Mango Shake", 25.0, 4),
            new Item("Vanilla Shake", 25.0, 4),
            new Item("Oreo Shake", 30.0, 4),
            new Item("Mirinda Shake", 25.0, 4),
            new Item("Cold Coffee", 30.0, 4),

    };
    private RecyclerView listView;
    private MenuAdapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baba);

        listView = findViewById(R.id.list_baba);
        int index = getIntent().getIntExtra("tag_baba", 0);
        RecyclerView.LayoutManager ol = new LinearLayoutManager(getApplicationContext());
        listView.setLayoutManager(ol);
        switch (index) {
            case 0:
                menuAdapter = new MenuAdapter(this, Arrays.asList(items_baba_juice_center_parantha));
                listView.setAdapter(menuAdapter);
                break;
            case 1:
                menuAdapter = new MenuAdapter(this, Arrays.asList(items_baba_juice_center_Patties));
                listView.setAdapter(menuAdapter);
                break;
            case 2:
                menuAdapter = new MenuAdapter(this, Arrays.asList(items_baba_juice_center_Bhelpuri));
                listView.setAdapter(menuAdapter);
                break;
            case 3:
                menuAdapter = new MenuAdapter(this, Arrays.asList(items_baba_juice_center_Snacks));
                listView.setAdapter(menuAdapter);
                break;
            case 4:
                menuAdapter = new MenuAdapter(this, Arrays.asList(items_baba_juice_center_Maggie));
                listView.setAdapter(menuAdapter);
                break;
            case 5:
                menuAdapter = new MenuAdapter(this, Arrays.asList(items_baba_juice_center_fruit_plate));
                listView.setAdapter(menuAdapter);
                break;
            case 6:
                menuAdapter = new MenuAdapter(this, Arrays.asList(items_baba_juice_center_cackes));
                listView.setAdapter(menuAdapter);
                break;
            case 7:
                menuAdapter = new MenuAdapter(this, Arrays.asList(items_baba_juice_center_juice));
                listView.setAdapter(menuAdapter);
                break;
            case 8:
                menuAdapter = new MenuAdapter(this, Arrays.asList(items_baba_juice_center_shakes));
                listView.setAdapter(menuAdapter);
                break;
            default:
                menuAdapter = new MenuAdapter(this, Arrays.asList(items_baba_juice_center_juice));
                listView.setAdapter(menuAdapter);
                break;
        }


    }
}

