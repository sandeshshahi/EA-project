package edu.miu.ea.sandesh.ordermanagementsystem.JMS.entity;

import java.time.LocalDateTime;

public class OrderInfo {
    private Long id;
    private LocalDateTime orderDate;
    private Double totalPrice;

    public OrderInfo() {
    }

    public OrderInfo(Long id, LocalDateTime orderDate, Double totalPrice) {
        this.id = id;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
