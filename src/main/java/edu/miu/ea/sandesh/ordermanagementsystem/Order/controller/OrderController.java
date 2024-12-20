package edu.miu.ea.sandesh.ordermanagementsystem.Order.controller;

import edu.miu.ea.sandesh.ordermanagementsystem.Common.Exception.NotFoundException;
import edu.miu.ea.sandesh.ordermanagementsystem.Order.Status;
import edu.miu.ea.sandesh.ordermanagementsystem.Order.entity.Order;
import edu.miu.ea.sandesh.ordermanagementsystem.Order.service.OrderService;
import edu.miu.ea.sandesh.ordermanagementsystem.Restaurant.entity.Restaurant;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{orderId}/restaurant")
    public Restaurant getRestaurantByOrderId(@PathVariable Long orderId) {
        Restaurant restaurant = orderService.getRestaurantByOrderId(orderId);
        if (restaurant == null) {
            throw new NotFoundException("Order with id " + orderId + " not found");
        }
        return restaurant;
    }

    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.findAllOrders();
    }

    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.findOrderById(id);
    }

    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/status/{status}")
    public List<Order> getOrdersByStatus(@PathVariable Status status) {
        return orderService.getOrdersByStatus(status);
    }

    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/restaurant/{restaurantId}")
    public List<Order> getOrdersByRestaurantId(@PathVariable Long restaurantId) {
        List<Order> ordersByRestaurant = orderService.getOrdersByRestaurantId(restaurantId);
        return ordersByRestaurant;
    }

    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CUSTOMER')")
    @PostMapping()
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CUSTOMER')")
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CUSTOMER')")
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/by-restaurant-and-status")
    public List<Order> getOrdersByRestaurantAndStatus(
            @RequestParam Long restaurantId, @RequestParam Status status) {
        return orderService.findOrdersByRestaurantAndStatus(restaurantId, status);
    }

    @GetMapping("/by-user-and-restaurant")
    public List<Order> getOrdersByUserAndRestaurant(@RequestParam Long userId, @RequestParam Long restaurantId) {
        return orderService.getOrdersByUserAndRestaurant(userId, restaurantId);
    }

}
