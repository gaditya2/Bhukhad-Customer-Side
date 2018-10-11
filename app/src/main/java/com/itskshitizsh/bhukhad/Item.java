package com.itskshitizsh.bhukhad;

public class Item {
    private String Name;
    private int canteen_id;
    private Double price;
    private Double rate;

    public Item(String name, Double price, int canteen_id) {
        Name = name;
        this.price = price;
        this.rate = -1.0;
        this.canteen_id = canteen_id;
    }

    public Item(String name, Double price, Double rate, int canteen_id) {
        Name = name;
        this.price = price;
        this.rate = rate;
        this.canteen_id = canteen_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public int getCanteen_id() {
        return canteen_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
