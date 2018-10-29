package com.itskshitizsh.bhukhad;

public class OrderAtVendor {
    private String orderId;
    private String orderStatus = "1";

    public OrderAtVendor() {
    }

    public OrderAtVendor(String orderStatus, String orderId) {
        this.orderStatus = orderStatus;
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
