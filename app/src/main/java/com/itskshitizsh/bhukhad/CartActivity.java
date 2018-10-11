package com.itskshitizsh.bhukhad;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import io.paperdb.Paper;

public class CartActivity extends AppCompatActivity {
    public static ArrayList<Purchased> cart_items = new ArrayList<>();
    public static ArrayList<Purchased> cart_items_bazzinga = new ArrayList<>();
    public static ArrayList<Purchased> cart_items_tfb = new ArrayList<>();
    public static ArrayList<Purchased> cart_items_baba = new ArrayList<>();
    public static ArrayList<Purchased> cart_items_amul = new ArrayList<>();
    public static ArrayList<Purchased> cart_items_vinayak = new ArrayList<>();
    TextView grandTxt;
    String order_id;
    String bazzingBill = "";
    Button checkoutt;
    String currentDateAndTime;
    String tfbBill = "";
    String babaBill = "";
    String amulBill = "";
    String vinayakBill = "";
    private boolean isNetworkConnected = false;

//    public static double calc_total() {
//        double sum = 0.0;
//        for (int i = 0; i < cart_items.size(); i++) {
//            sum = sum + cart_items.get(i).getTotal_price();
//        }
//        return sum;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        grandTxt = findViewById(R.id.grandTotal);
        checkoutt = findViewById(R.id.checkout);
        for (int i = 0; i < cart_items_bazzinga.size(); i++) {
            cart_items.add(cart_items_bazzinga.get(i));
        }

        for (int i = 0; i < cart_items_amul.size(); i++) {
            cart_items.add(cart_items_amul.get(i));
        }

        for (int i = 0; i < cart_items_vinayak.size(); i++) {
            cart_items.add(cart_items_vinayak.get(i));
        }

        for (int i = 0; i < cart_items_tfb.size(); i++) {
            cart_items.add(cart_items_tfb.get(i));
        }
        for (int i = 0; i < cart_items_baba.size(); i++) {
            cart_items.add(cart_items_baba.get(i));
        }


        Toast.makeText(this, "" + currentDateAndTime, Toast.LENGTH_SHORT).show();

        RecyclerView listView1 = findViewById(R.id.cart_list);
        listView1.setAdapter(new CartAdapter(this, cart_items));
        RecyclerView.LayoutManager ool = new LinearLayoutManager(getApplicationContext());
        listView1.setLayoutManager(ool);
        try {
            ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            if (conMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED
                    || conMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {

                isNetworkConnected = true;

            } else {
                Toast.makeText(this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        Paper.init(this);
        bazzingBill = bazzingBill + "Customer Id :" + order_id + "\n";

        for (int i = 0; i < cart_items_bazzinga.size(); i++) {
            bazzingBill = bazzingBill + "Name:" + cart_items_bazzinga.get(i).item.getName() + "\n " + "Quantity:" + cart_items_bazzinga.get(i).quantity
                    + "Total Price :" + cart_items_bazzinga.get(i).getTotal_price() + "\n \n";
        }



        checkoutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                final Dialog dialog = new Dialog(CartActivity.this);
//                dialog.setContentView(R.layout.dialog_checkout);
//                dialog.setTitle("Bill");
//                TextView billText = dialog.findViewById(R.id.bill);
                Date c = Calendar.getInstance().getTime();
                System.out.println("Current time => " + c);
                currentDateAndTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(c);
                order_id = SignInActivity.id + currentDateAndTime;

                if (isNetworkConnected) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    final DatabaseReference orderTable = database.getReference("Orders");
                    orderTable.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Order order1 = new Order(SignInActivity.currentUser, currentDateAndTime, cart_items_bazzinga);
                            Order order2 = new Order(SignInActivity.currentUser, currentDateAndTime, cart_items_amul);
                            Order order3 = new Order(SignInActivity.currentUser, currentDateAndTime, cart_items_tfb);
                            Order order4 = new Order(SignInActivity.currentUser, currentDateAndTime, cart_items_vinayak);
                            Order order5 = new Order(SignInActivity.currentUser, currentDateAndTime, cart_items_baba);

                            if (dataSnapshot.child(order_id).exists()) {

                            } else {

                                orderTable.child(order_id).child("Bazzinga").setValue(order1);

                                orderTable.child(order_id).child("amul").setValue(order2);

                                orderTable.child(order_id).child("tfb").setValue(order3);

                                orderTable.child(order_id).child("vinayak").setValue(order4);

                                orderTable.child(order_id).child("baba").setValue(order5);
                                Toast.makeText(CartActivity.this, "Order Placed !", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        });
    }
}
