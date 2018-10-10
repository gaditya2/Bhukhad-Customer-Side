package com.itskshitizsh.bhukhad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;

public class Bazzinga extends AppCompatActivity {
    private RecyclerView listView;
    private MenuAdapter menuAdapter;
    Item[] items_bazzinga_smoothies = {
            new Item("Cupcake", 15.0,"Bazzinga"),
            new Item("Donut", 16.0,"Bazzinga"),
            new Item("Eclair", 20.0,"Bazzinga"),
            new Item("Froyo", 30.0,"Bazzinga"),
            new Item("GingerBread", 40.0,"Bazzinga"),
            new Item("Honeycomb", 30.0,"Bazzinga"),
            new Item("Ice Cream Sandwich", 20.0,"Bazzinga")
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bazzinga);

        listView = findViewById(R.id.bazzingaMenu);
        int index = getIntent().getIntExtra("tag", 0);
        RecyclerView.LayoutManager ol = new LinearLayoutManager(getApplicationContext());
        listView.setLayoutManager(ol);
        switch (index) {
            default:
                menuAdapter = new MenuAdapter(this, Arrays.asList(items_bazzinga_smoothies));
                listView.setAdapter(menuAdapter);
                break;
        }



    }
}
