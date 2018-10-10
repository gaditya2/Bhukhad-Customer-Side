package com.itskshitizsh.bhukhad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    public static List<Purchased> cart_items=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
//

        ListView listView=findViewById(R.id.cart_list);
        listView.setAdapter(new CartAdapter(this,0,cart_items));

    }

    public static void addItem(Purchased purchased)
    {
        cart_items.add(purchased);
    }
}
