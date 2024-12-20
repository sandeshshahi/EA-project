package edu.miu.ea.sandesh.ordermanagementsystem.OrderItem.controller;

import edu.miu.ea.sandesh.ordermanagementsystem.OrderItem.entity.OrderItem;
import edu.miu.ea.sandesh.ordermanagementsystem.OrderItem.service.OrderItemService;
import edu.miu.ea.sandesh.ordermanagementsystem.common.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/by-order/{orderId}")
    public List<OrderItem> getOrderItemsByOrderId(@PathVariable("orderId") Long orderId) {
        List<OrderItem> orderItems = orderItemService.findOrderItemByOrderId(orderId);
        if (orderItems == null) {
            throw new NotFoundException("Order with id " + orderId + " does not exist");
        }
        return orderItems;
    }

    @GetMapping()
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.findAllOrderItems();
    }

    @PostMapping()
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.createOrderItem(orderItem);
    }

    @PutMapping("/{id}")
    public OrderItem updateOrderItem(@PathVariable("id") Long orderId, @RequestBody OrderItem orderItem) {
        return orderItemService.updateOrderItem(orderId, orderItem);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderItem(@PathVariable("id") Long orderId) {
        orderItemService.deleteOrderItem(orderId);
    }

    
}
