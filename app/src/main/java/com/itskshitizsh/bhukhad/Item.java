package com.itskshitizsh.bhukhad;

public class Item {
    private String Name;
    private String canteen_name;
    private Double price;
    private Double rate;

    public Item(String name, Double price , String canteen_name) {
        Name = name;
        this.price = price;
        this.rate = -1.0;
        this.canteen_name=canteen_name;
    }

    public Item(String name, Double price, Double rate,String canteen_name) {
        Name = name;
        this.price = price;
        this.rate = rate;
        this.canteen_name=canteen_name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public String getCanteen_name() {
        return canteen_name;
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
