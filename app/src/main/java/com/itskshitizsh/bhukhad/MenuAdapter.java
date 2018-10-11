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
                switch (item.getCanteen_id()) {
                    case 0:
                        CartActivity.cart_items_bazzinga.add(new Purchased(item, 1));
                        break;
                    case 1:
                        CartActivity.cart_items_amul.add(new Purchased(item, 1));
                        break;
                    case 2:
                        CartActivity.cart_items_tfb.add(new Purchased(item, 1));
                        break;
                    case 3:
                        CartActivity.cart_items_vinayak.add(new Purchased(item, 1));
                        break;
                    case 4:
                        CartActivity.cart_items_baba.add(new Purchased(item, 1));
                        break;

                }
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
