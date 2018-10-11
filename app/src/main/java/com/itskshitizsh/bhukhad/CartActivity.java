package com.itskshitizsh.bhukhad;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    public static List<Purchased> cart_items=new ArrayList<>();
    TextView grandTxt;
    Button checkoutt;

    String currentDateAndTime;

    public static double calc_total() {
        double sum = 0.0;
        for (int i = 0; i < cart_items.size(); i++) {
            sum = sum + cart_items.get(i).getTotal_price();
        }
        return sum;
    }

    public static void addItem(Purchased purchased) {
        cart_items.add(purchased);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        grandTxt = findViewById(R.id.grandTotal);
        checkoutt = findViewById(R.id.checkout);
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        currentDateAndTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(c);
        Toast.makeText(this, "" + currentDateAndTime, Toast.LENGTH_SHORT).show();

        RecyclerView listView1 = findViewById(R.id.cart_list);
        listView1.setAdapter(new CartAdapter(this, cart_items));
        RecyclerView.LayoutManager ool = new LinearLayoutManager(getApplicationContext());
        listView1.setLayoutManager(ool);
        checkoutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                grandTxt.setText(calc_total() + "");
                final Dialog dialog = new Dialog(CartActivity.this);
                dialog.setContentView(R.layout.dialog_checkout);
                dialog.setTitle("Bill");
                TextView billText = dialog.findViewById(R.id.bill);
                billText.append("Customer Id :" + SignInActivity.id + currentDateAndTime + "\n");
                for (int i = 0; i < cart_items.size(); i++) {
                    billText.append("Name:" + cart_items.get(i).item.getName() + "\n " + "Quantity:" + cart_items.get(i).quantity
                            + "Total Price :" + cart_items.get(i).getTotal_price() + "\n \n");
                }
                billText.append("\nGrand Total:" + calc_total());
                dialog.show();

            }
        });
    }
}
