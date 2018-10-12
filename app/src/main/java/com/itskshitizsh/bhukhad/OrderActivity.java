package com.itskshitizsh.bhukhad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        TextView bazzingaBills = findViewById(R.id.bazzingaBills);
        bazzingaBills.setText(CartActivity.tfbBill);

        TextView babaBills = findViewById(R.id.babaBills);
        babaBills.setText(CartActivity.babaBill);

        TextView amulBills = findViewById(R.id.amulBills);
        amulBills.setText(CartActivity.amulBill);

        TextView foodBarnBills = findViewById(R.id.foodBarnBills);
        foodBarnBills.setText(CartActivity.tfbBill);
    }
}
