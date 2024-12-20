package edu.miu.ea.sandesh.ordermanagementsystem.Order.service;

import edu.miu.ea.sandesh.ordermanagementsystem.Order.Status;
import edu.miu.ea.sandesh.ordermanagementsystem.Order.entity.Order;
import edu.miu.ea.sandesh.ordermanagementsystem.Order.repository.OrderRepository;
import edu.miu.ea.sandesh.ordermanagementsystem.Restaurant.entity.Restaurant;
import edu.miu.ea.sandesh.ordermanagementsystem.common.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order findOrderById(long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElse(null);
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public Order updateOrder(Long id, Order order) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            Order orderToUpdate = orderOptional.get();
            orderToUpdate.setOrderDate(order.getOrderDate());
            orderToUpdate.setTotalPrice(order.getTotalPrice());
            orderToUpdate.setOrderStatus(order.getOrderStatus());
            orderToUpdate.setRestaurant(order.getRestaurant());
            orderToUpdate.setOrderItems(order.getOrderItems());
            return orderRepository.save(orderToUpdate);
        }
        return null;
    }

    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }

    public Restaurant getRestaurantByOrderId(long orderId) {
        return orderRepository.findRestaurantByOrderId(orderId);
    }

    public List<Order> getOrdersByStatus(Status status) {
        List<Order> orders = orderRepository.findByOrderStatus(status);
        if (orders.isEmpty()) {
            throw new NotFoundException("No orders found");
        }
        return orders;
    }


    public List<Order> getOrdersByRestaurantId(long restaurantId) {
        return orderRepository.findByRestaurantId(restaurantId);
    }
}
