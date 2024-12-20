package edu.miu.ea.sandesh.ordermanagementsystem.OrderItem.controller;

import edu.miu.ea.sandesh.ordermanagementsystem.Common.Exception.NotFoundException;
import edu.miu.ea.sandesh.ordermanagementsystem.OrderItem.entity.OrderItem;
import edu.miu.ea.sandesh.ordermanagementsystem.OrderItem.service.OrderItemService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CUSTOMER')")
    @GetMapping("/by-order/{orderId}")
    public List<OrderItem> getOrderItemsByOrderId(@PathVariable("orderId") Long orderId) {
        List<OrderItem> orderItems = orderItemService.findOrderItemByOrderId(orderId);
        if (orderItems == null) {
            throw new NotFoundException("Order with id " + orderId + " does not exist");
        }
        return orderItems;
    }

    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping()
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.findAllOrderItems();
    }

    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CUSTOMER')")
    @PostMapping()
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.createOrderItem(orderItem);
    }

    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CUSTOMER')")
    @PutMapping("/{id}")
    public OrderItem updateOrderItem(@PathVariable("id") Long orderId, @RequestBody OrderItem orderItem) {
        return orderItemService.updateOrderItem(orderId, orderItem);
    }

    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CUSTOMER')")
    @DeleteMapping("/{id}")
    public void deleteOrderItem(@PathVariable("id") Long orderId) {
        orderItemService.deleteOrderItem(orderId);
    }


}
