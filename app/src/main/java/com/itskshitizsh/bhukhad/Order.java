package com.itskshitizsh.bhukhad;

import java.util.ArrayList;

public class Order {
    ArrayList<Purchased> purchasedItems;
    private String OrderId;
    private String CanteenName;
    private User user;
    private String dateTime;

    public Order(User user, String dateTime, ArrayList<Purchased> purchasedItems) {
        this.user = user;
        this.dateTime = dateTime;
        this.purchasedItems = purchasedItems;
    }

    public Order(String orderId, String canteenName, User user, String dateTime, ArrayList<Purchased> purchasedItems) {

        OrderId = orderId;
        CanteenName = canteenName;
        this.user = user;
        this.dateTime = dateTime;
        this.purchasedItems = purchasedItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "purchasedItems=" + purchasedItems +
                ", OrderId='" + OrderId + '\'' +
                ", CanteenName='" + CanteenName + '\'' +
                ", user=" + user +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getCanteenName() {
        return CanteenName;
    }

    public void setCanteenName(String canteenName) {
        CanteenName = canteenName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return dateTime;
    }

    public void setDate(String date) {
        this.dateTime = dateTime;
    }

    public ArrayList<Purchased> getPurchasedItems() {
        return purchasedItems;
    }

    public void setPurchasedItems(ArrayList<Purchased> purchasedItems) {
        this.purchasedItems = purchasedItems;
    }
}
