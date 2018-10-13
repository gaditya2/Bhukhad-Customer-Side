package com.itskshitizsh.bhukhad;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {
    private Context mContext;
    private List<Item> itemsList;

    public MenuAdapter(Context mContext, List<Item> itemsList) {
        this.mContext = mContext;
        this.itemsList = itemsList;
    }

    @Override
    public MenuAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_single, parent, false);
        return new MenuAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MenuAdapter.MyViewHolder holder, final int position) {
        final Item item = itemsList.get(position);
        //int quantity = Integer.parseInt(String.valueOf(item.getItemQty()));
        holder.nameItem.setText(item.getName());
        holder.priceItem.setText("\u20b9 " + String.valueOf(item.getPrice()));
        holder.addcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartActivity.cart_items.add(new Purchased(item, 1));
//                Dbhelper mDbHelper = new Dbhelper(mContext);
//                // Gets the data repository in write mode
//                SQLiteDatabase db = mDbHelper.getWritableDatabase();
//
//// Create a new map of values, where column names are the keys
//                ContentValues values = new ContentValues();
//                values.put(DbContract.Dbentry.COLUMN_NAME_PRODUCT, item.getName());
//                values.put(DbContract.Dbentry.COLUMN_NAME_QUANTITY, 1);
//                values.put(DbContract.Dbentry.COLUMN_NAME_PRICE,item.getPrice());
//                values.put(DbContract.Dbentry.COLUMN_NAME_CANTEEN,item.getCanteen_id());
//
//// Insert the new row, returning the primary key value of the new row
//                long newRowId = db.insert(DbContract.Dbentry.TABLE_NAME, null, values);

                holder.addcart.setVisibility(View.INVISIBLE);
                holder.addcart.setActivated(false);
                Toast.makeText(mContext, itemsList.get(position).getName() + "added to cart", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView nameItem, priceItem;
        public Button addcart;

        public MyViewHolder(View view) {
            super(view);
            nameItem = view.findViewById(R.id.nameText);
            priceItem = view.findViewById(R.id.priceText);

            addcart = view.findViewById(R.id.add_to_cart);
        }
    }

}
