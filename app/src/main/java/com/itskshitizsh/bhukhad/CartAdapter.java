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


        return convertView;



    }
}
