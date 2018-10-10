package com.itskshitizsh.bhukhad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class CartAdapter extends ArrayAdapter {
    Purchased pur_item;
    TextView quantity;
    Button inc_btn;
    Button dec_btn;
    Button rem_btn;

    public CartAdapter(@NonNull Context context, int resource, @NonNull List objects) {

        super(context, 0, objects);
    }

    @NonNull
    @SuppressLint("SetTextI18n")
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        pur_item= (Purchased) getItem(position);


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cart_single, parent, false);
        }
        TextView NameView = convertView.findViewById(R.id.nameCartText);
        assert pur_item != null;
        NameView.setText(pur_item.getItem().getName());

        TextView NumberView = convertView.findViewById(R.id.priceCartText);
        NumberView.setText(pur_item.getTotal_price() + " ");

        TextView canteen=convertView.findViewById(R.id.canteenNameCart);
        canteen.setText(pur_item.getItem().getCanteen_name()+" ");
        pur_item = CartActivity.cart_items.get(position);
        inc_btn = convertView.findViewById(R.id.increment);
        dec_btn = convertView.findViewById(R.id.decrement);
        rem_btn = convertView.findViewById(R.id.remove);

        quantity = convertView.findViewById(R.id.quantity_text_view);
        inc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int new_quan = pur_item.getQuantity() + 1;
                if (new_quan > 50) {
                    Toast.makeText(getContext(), "You can not order more than 50", Toast.LENGTH_SHORT).show();
                } else {
                    pur_item.setQuantity(new_quan);
                    quantity.setText(new_quan + " ");
                }
            }
        });
        dec_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int new_quan = pur_item.getQuantity() - 1;
                if (new_quan <= 0) {
                    dec_btn.setVisibility(View.INVISIBLE);
                    rem_btn.setVisibility(View.VISIBLE);
                } else {
                    pur_item.setQuantity(new_quan);
                    quantity.setText(new_quan + "");

                }
            }
        });

        return convertView;



    }
}
