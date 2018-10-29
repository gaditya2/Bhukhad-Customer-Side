package com.itskshitizsh.bhukhad;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import io.paperdb.Paper;

import static com.itskshitizsh.bhukhad.MenuAdapter.mDbHelper;

public class CartActivity extends AppCompatActivity {
    public static ArrayList<Purchased> cart_items = new ArrayList<>();
    public static ArrayList<Purchased> cart_items_bazzinga = new ArrayList<>();
    public static ArrayList<Purchased> cart_items_tfb = new ArrayList<>();
    public static ArrayList<Purchased> cart_items_baba = new ArrayList<>();
    public static ArrayList<Purchased> cart_items_amul = new ArrayList<>();
    public static ArrayList<Purchased> cart_items_vinayak = new ArrayList<>();
    String order_id;
    String bazzingBill = "";
    Button checkoutt;
    String currentDateAndTime;
    static String tfbBill = "";
    static String babaBill = "";
    static String amulBill = "";
    static String vinayakBill = "";
    private boolean isNetworkConnected = false;
    Order order1, order2, order3, order4, order5;


    SQLiteDatabase sdb;

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

// New value for one column
        for (int i = 0; i < cart_items.size(); i++) {
            ContentValues values = new ContentValues();
            values.put(DbContract.Dbentry.COLUMN_NAME_QUANTITY, cart_items.get(i).getQuantity());

// Which row to update, based on the title
            String selection = DbContract.Dbentry.COLUMN_NAME_PRODUCT + " LIKE ?";
            String[] selectionArgs = {cart_items.get(i).getItem().getName()};

            int count = db.update(
                    DbContract.Dbentry.TABLE_NAME,
                    values,
                    selection,
                    selectionArgs);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        checkoutt = findViewById(R.id.checkout);
        try {
            sdb = mDbHelper.getReadableDatabase();
            String[] projection = {
                    DbContract.Dbentry.COLUMN_NAME_PRODUCT,
                    DbContract.Dbentry.COLUMN_NAME_QUANTITY,
                    DbContract.Dbentry.COLUMN_NAME_CANTEEN
            };


// Filter results WHERE "title" = 'My Title'


            Cursor cursor = sdb.query(
                    DbContract.Dbentry.TABLE_NAME,   // The table to query
                    projection,             // The array of columns to return (pass null to get all)
                    null,          // The columns for the WHERE clause
                    null,      // The values for the WHERE clause
                    null,          // don't group the rows
                    null,          // don't filter by row groups
                    null            // The sort order
            );

            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    cart_items.add(new Purchased(new Item(cursor.getString(0), 0.0, cursor.getInt(2)), cursor.getInt(2)));
                }
            }
            for (Purchased p : cart_items) {
                switch (p.getCanteen_id()) {
                    case 0:
                        cart_items_bazzinga.add(p);
                        break;
                    case 1:
                        cart_items_amul.add(p);
                        break;
                    case 2:
                        cart_items_tfb.add(p);
                        break;
                    case 3:
                        cart_items_vinayak.add(p);
                        break;
                    case 4:
                        cart_items_baba.add(p);
                        break;
                    default:
                        break;
                }
            }


            if (currentDateAndTime != null) {

            }

            RecyclerView listView1 = findViewById(R.id.cart_list);
            listView1.setAdapter(new CartAdapter(this, cart_items));
            RecyclerView.LayoutManager ool = new LinearLayoutManager(getApplicationContext());
            listView1.setLayoutManager(ool);

            Date c = Calendar.getInstance().getTime();
            currentDateAndTime = String.valueOf(System.currentTimeMillis());
            order_id = currentDateAndTime;

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

            checkoutt.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

//                final Dialog dialog = new Dialog(CartActivity.this);
//                dialog.setContentView(R.layout.dialog_checkout);
//                dialog.setTitle("Bill");
//                TextView billText = dialog.findViewById(R.id.bill);
                    if (isNetworkConnected) {
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        final DatabaseReference orderTable = database.getReference("Orders").child(order_id);
                        orderTable.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                order1 = new Order(SignInActivity.currentUser, currentDateAndTime, cart_items_bazzinga);
                                order2 = new Order(SignInActivity.currentUser, currentDateAndTime, cart_items_amul);
                                order3 = new Order(SignInActivity.currentUser, currentDateAndTime, cart_items_tfb);
                                order4 = new Order(SignInActivity.currentUser, currentDateAndTime, cart_items_vinayak);
                                order5 = new Order(SignInActivity.currentUser, currentDateAndTime, cart_items_baba);

                                if (dataSnapshot.child(order_id).exists()) {
                                    Toast.makeText(CartActivity.this, "Similar ID Already Exists", Toast.LENGTH_SHORT).show();
                                } else {

                                    orderTable.child("Bazzinga").setValue(order1);

                                    orderTable.child("Juice Parlour Shop").setValue(order2);

                                    orderTable.child("Food Barn").setValue(order3);

                                    orderTable.child("Vinayak Caters").setValue(order4);

                                    orderTable.child("Baba Juice Corner").setValue(order5);

                                    Toast.makeText(CartActivity.this, "Order Placed !\n Visit My Orders", Toast.LENGTH_SHORT).show();
                                    bazzingBill = order_id + "\n";

                                    for (int i = 0; i < cart_items_bazzinga.size(); i++) {
                                        bazzingBill = bazzingBill.concat("Name:") + cart_items_bazzinga.get(i).item.getName() + "\n " + "Quantity:" + cart_items_bazzinga.get(i).quantity
                                                + "Total Price :" + cart_items_bazzinga.get(i).getTotal_price() + "\n \n";
                                    }
                                    tfbBill = order_id + "\n";
                                    for (int i = 0; i < cart_items_tfb.size(); i++) {
                                        tfbBill = tfbBill.concat("Name:") + cart_items_tfb.get(i).item.getName() + "\n " + "Quantity:" + cart_items_tfb.get(i).quantity
                                                + "Total Price :" + cart_items_tfb.get(i).getTotal_price() + "\n \n";
                                    }


                                    babaBill = order_id + "\n";

                                    for (int i = 0; i < cart_items_tfb.size(); i++) {
                                        babaBill = babaBill.concat("Name:") + cart_items_baba.get(i).item.getName() + "\n " + "Quantity:" + cart_items_baba.get(i).quantity
                                                + "Total Price :" + cart_items_baba.get(i).getTotal_price() + "\n \n";
                                    }


                                    amulBill = order_id + "\n";

                                    for (int i = 0; i < cart_items_tfb.size(); i++) {
                                        amulBill = amulBill.concat("Name:") + cart_items_amul.get(i).item.getName() + "\n " + "Quantity:" + cart_items_amul.get(i).quantity
                                                + "Total Price :" + cart_items_amul.get(i).getTotal_price() + "\n \n";
                                    }


                                    vinayakBill = vinayakBill + "Customer Id :" + order_id + "\n";

                                    for (int i = 0; i < cart_items_vinayak.size(); i++) {
                                        vinayakBill = vinayakBill.concat("Name:") + cart_items_vinayak.get(i).item.getName() + "\n " + "Quantity:" + cart_items_vinayak.get(i).quantity
                                                + "Total Price :" + cart_items_vinayak.get(i).getTotal_price() + "\n \n";
                                    }

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
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Cart is empty! Add Items to Cart!", Toast.LENGTH_LONG).show();
            startActivity(new Intent(CartActivity.this, HomeActivity.class));
            finish();
        }
    }
}
