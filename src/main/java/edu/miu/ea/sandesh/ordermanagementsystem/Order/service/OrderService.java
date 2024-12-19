package edu.miu.ea.sandesh.ordermanagementsystem.Order.service;

import edu.miu.ea.sandesh.ordermanagementsystem.Order.entity.Order;
import edu.miu.ea.sandesh.ordermanagementsystem.Order.repository.OrderRepository;
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

    public Order updateOrder(Order order) {
        Optional<Order> orderOptional = orderRepository.findById(order.getId());
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

}
