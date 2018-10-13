package com.itskshitizsh.bhukhad;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {


    private Context mContext;
    private List<Purchased> itemsList;

    public CartAdapter(Context mContext, List<Purchased> itemsList) {
        this.mContext = mContext;
        this.itemsList = itemsList;
    }

    @Override
    public CartAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_single, parent, false);
        return new CartAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int i) {
        final Purchased pur_item = itemsList.get(i);
        holder.name_txt.setText(pur_item.getItem().getName());
        holder.total.setText(pur_item.getTotal_price() + "");
        int cant_id = pur_item.getCanteen_id();
        String Canteen = "";
        switch (cant_id) {
            case 0:
                Canteen = "Bazzinga";
                break;
            case 1:
                Canteen = "amul";
                break;
            case 2:
                Canteen = "the food barn";
                break;
            case 3:
                Canteen = "Vinayak Caters";
                break;
            case 4:
                Canteen = "Baba";
                break;
        }

        holder.CanteenName.setText(Canteen + "");
        holder.inc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int new_quan = pur_item.getQuantity() + 1;
                if (new_quan > 50) {
                    Toast.makeText(mContext, "You can not order more than 50", Toast.LENGTH_SHORT).show();
                } else {
                    pur_item.setQuantity(new_quan);
                    holder.quantity.setText(new_quan + " ");
                    holder.total.setText("\u20b9 " + pur_item.getTotal_price());


                }
            }

        });
        holder.dec_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int new_quan = pur_item.getQuantity() - 1;
                if (new_quan <= 0) {
                    holder.dec_btn.setVisibility(View.INVISIBLE);
                    holder.rem_btn.setVisibility(View.VISIBLE);
                } else {
                    pur_item.setQuantity(new_quan);
                    holder.quantity.setText(new_quan + "");
                    holder.total.setText("\u20b9 " + pur_item.getTotal_price());

                }
            }
        });
        holder.rem_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView quantity, name_txt, total, CanteenName;
        public Button inc_btn;
        public Button dec_btn;
        public Button rem_btn;

        public MyViewHolder(View view) {
            super(view);
            CanteenName = view.findViewById(R.id.canteenNameCart);
            name_txt = view.findViewById(R.id.nameCartText);
            total = view.findViewById(R.id.priceCartText);
            quantity = view.findViewById(R.id.quantity_text_view);
            inc_btn = view.findViewById(R.id.increment);
            rem_btn = view.findViewById(R.id.remove);
            dec_btn = view.findViewById(R.id.decrement);
        }
    }

}
