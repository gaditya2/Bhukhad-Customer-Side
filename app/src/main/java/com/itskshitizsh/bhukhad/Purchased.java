package com.itskshitizsh.bhukhad;

public class Purchased {
    Item item;
    int quantity;
    double total_price;
    int canteen_id;

    public Item getItem() {
        return item;
    }

    public Purchased(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.canteen_id = item.getCanteen_id();
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCanteen_id() {
        return canteen_id;
    }

    public double getTotal_price() {
        total_price=quantity*(item.getPrice());
        return total_price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
