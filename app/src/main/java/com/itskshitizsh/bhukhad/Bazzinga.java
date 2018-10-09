package com.itskshitizsh.bhukhad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

public class Bazzinga extends AppCompatActivity {
    Item[] items_bazzinga_smoothies = {
            new Item("Cupcake", 15.0,"Bazzinga"),
            new Item("Donut", 16.0,"Bazzinga"),
            new Item("Eclair", 20.0,"Bazzinga"),
            new Item("Froyo", 30.0,"Bazzinga"),
            new Item("GingerBread", 40.0,"Bazzinga"),
            new Item("Honeycomb", 30.0,"Bazzinga"),
            new Item("Ice Cream Sandwich", 20.0,"Bazzinga")
    };
    int pos;
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
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Button cart_btn=view.findViewById(R.id.add_to_cart);
               pos=i;
               cart_btn.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       CartActivity.addItem(new Purchased(items_bazzinga_smoothies[pos],1));


                   }
               });
           }
       });


    }
}
