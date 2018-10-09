package com.itskshitizsh.bhukhad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static com.itskshitizsh.bhukhad.CartActivity.cart_items;

public class MenuAdapter extends ArrayAdapter {
    Item item;

    public MenuAdapter(@NonNull Context context, int resource, @NonNull List objects) {

        super(context, 0, objects);
    }

    @NonNull
    @SuppressLint("SetTextI18n")
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
         item= (Item) getItem(position);


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_single, parent, false);
        }
        TextView NameView = convertView.findViewById(R.id.nameText);
        assert item != null;
        NameView.setText(item.getName());

        TextView NumberView = convertView.findViewById(R.id.priceText);
        NumberView.setText(item.getPrice() + " ");


        return convertView;

    }
}
