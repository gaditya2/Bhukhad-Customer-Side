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

import java.util.List;

public class MenuAdapter extends ArrayAdapter {
    int count;
    TextView quantity;

    public MenuAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, 0, objects);
    }

    @NonNull
    @SuppressLint("SetTextI18n")
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Item item = (Item) getItem(position);


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_single, parent, false);
        }
        count = 0;
        TextView NameView = convertView.findViewById(R.id.nameText);
        assert item != null;
        NameView.setText(item.getName());

        TextView NumberView = convertView.findViewById(R.id.priceText);
        NumberView.setText(item.getPrice() + " ");
        quantity = convertView.findViewById(R.id.quantity_text_view);
        Button inc_btn = convertView.findViewById(R.id.increment);
        Button dec_btn = convertView.findViewById(R.id.decrement);

        inc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                quantity.setText(count + "");
            }
        });
        dec_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                quantity.setText(count + "");
            }
        });
        return convertView;

    }
}
