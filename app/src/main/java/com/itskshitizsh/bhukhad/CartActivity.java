package com.itskshitizsh.bhukhad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    public static List<Purchased> cart_items=new ArrayList<>();
    TextView quantity;
    Button inc_btn;
    Button dec_btn;
    Button rem_btn;
    Purchased pur_item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
//

        ListView listView=findViewById(R.id.cart_list);
        listView.setAdapter(new CartAdapter(this,0,cart_items));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pur_item=cart_items.get(i);
                inc_btn=view.findViewById(R.id.increment);
                dec_btn=view.findViewById(R.id.decrement);
                rem_btn=view.findViewById(R.id.remove);

        quantity=view.findViewById(R.id.quantity_text_view);
        inc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int new_quan= pur_item.getQuantity()+1;
                if(new_quan>50)
                {
                    Toast.makeText(CartActivity.this, "You can not order more than 50", Toast.LENGTH_SHORT).show();
                }
                else {
                    pur_item.setQuantity(new_quan);
                    quantity.setText(new_quan+" ");
                }
            }
        });
        dec_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int new_quan= pur_item.getQuantity()-1;
                if (new_quan<=0)
                {
                    dec_btn.setVisibility(View.INVISIBLE);
                    rem_btn.setVisibility(View.VISIBLE);
                }
                else {
                    pur_item.setQuantity(new_quan);
                    quantity.setText(new_quan+"");

                }
            }
        });
            }
        });
    }
    public static void addItem(Purchased purchased)
    {
        cart_items.add(purchased);
    }
}
