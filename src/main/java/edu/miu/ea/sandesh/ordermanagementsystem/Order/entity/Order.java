package edu.miu.ea.sandesh.ordermanagementsystem.Order.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.miu.ea.sandesh.ordermanagementsystem.Order.Status;
import edu.miu.ea.sandesh.ordermanagementsystem.OrderItem.entity.OrderItem;
import edu.miu.ea.sandesh.ordermanagementsystem.Restaurant.entity.Restaurant;
import edu.miu.ea.sandesh.ordermanagementsystem.User.entity.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "CUSTOMER_ORDER")
@NamedQuery(
        name = "Order.findRestaurantByOrderId",
        query = "SELECT o.restaurant FROM Order o WHERE o.id =:orderId"
)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderDate;
    private Double totalPrice;
    private Status orderStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonIgnore
    private Restaurant restaurant;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Version
    private Long version;

    public Order() {
    }

    public Order(LocalDateTime orderDate, Double totalPrice, Status orderStatus, Restaurant restaurant, User user) {
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        this.restaurant = restaurant;
        this.user = user;
    }

    public Long getId() {
        return id;
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

    public Status getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }

    @JsonIgnore
    public Restaurant getRestaurant() {
        return restaurant;
    }

    @JsonIgnore
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @JsonIgnore
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    @JsonIgnore
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    @JsonIgnore
    public void setUser(User user) {
        this.user = user;
    }
}
