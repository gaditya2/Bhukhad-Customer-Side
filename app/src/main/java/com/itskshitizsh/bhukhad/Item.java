package com.itskshitizsh.bhukhad;

public class Item {
    private String Name;
    private String desc;
    private Double price;
    private Double rate;

    public Item(String name, Double price) {
        Name = name;
        this.price = price;
        this.rate = -1.0;
    }

    public Item(String name, Double price, Double rate) {
        Name = name;
        this.price = price;
        this.rate = rate;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
