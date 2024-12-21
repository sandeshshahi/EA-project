package edu.miu.ea.sandesh.ordermanagementsystem.JMS.controller;

import edu.miu.ea.sandesh.ordermanagementsystem.JMS.entity.OrderInfo;
import edu.miu.ea.sandesh.ordermanagementsystem.JMS.producer.Producer;
import edu.miu.ea.sandesh.ordermanagementsystem.Order.entity.Order;
import edu.miu.ea.sandesh.ordermanagementsystem.Order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController()
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private Producer producer;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping(path = "/orders/{id}")
    public OrderInfo getOrders(@PathVariable Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setId(order.get().getId());
            orderInfo.setOrderDate(order.get().getOrderDate());
            orderInfo.setTotalPrice(order.get().getTotalPrice());
            producer.sendOrder(orderInfo);
            return orderInfo;
        }
        return null;
    }


}
