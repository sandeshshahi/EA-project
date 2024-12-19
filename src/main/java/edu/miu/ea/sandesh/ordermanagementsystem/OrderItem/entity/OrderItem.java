package edu.miu.ea.sandesh.ordermanagementsystem.OrderItem.entity;

import edu.miu.ea.sandesh.ordermanagementsystem.MenuItem.entity.MenuItem;
import edu.miu.ea.sandesh.ordermanagementsystem.Order.entity.Order;
import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private Double unitPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order; // Links to the Order

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_item_id", nullable = false)
    private MenuItem menuItem; // Links to the MenuItem being ordered

    public OrderItem() {
    }

    public OrderItem(MenuItem menuItem, int quantity, Double unitPrice, Order order) {
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.order = order;
    }


    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getOrderId() {
        return id;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }
}
