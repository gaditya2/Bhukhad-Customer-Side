package com.itskshitizsh.bhukhad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.Arrays;

public class Bazzinga extends AppCompatActivity {
    Item[] items_bazzinga_smoothies = {
            new Item("Cupcake", 15.0),
            new Item("Donut", 16.0),
            new Item("Eclair", 20.0),
            new Item("Froyo", 30.0),
            new Item("GingerBread", 40.0),
            new Item("Honeycomb", 30.0),
            new Item("Ice Cream Sandwich", 20.0)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bazzinga);
        MenuAdapter menuAdapter;
        ListView listView = findViewById(R.id.bazzingaMenu);
        int index = getIntent().getIntExtra("tag", 0);
        switch (index) {
            case 2:
                menuAdapter = new MenuAdapter(this, 0, Arrays.asList(items_bazzinga_smoothies));
                listView.setAdapter(menuAdapter);
                break;
        }


    }
}
