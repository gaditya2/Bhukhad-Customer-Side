package com.itskshitizsh.bhukhad;

public class Purchased {
    Item item;
    int quantity;
    double total_price;
    String canteen_name;

    public Item getItem() {
        return item;
    }

    public Purchased(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal_price() {
        total_price=quantity*(item.getPrice());
        return total_price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
