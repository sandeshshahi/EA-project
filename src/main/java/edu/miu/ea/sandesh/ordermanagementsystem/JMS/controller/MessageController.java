package edu.miu.ea.sandesh.ordermanagementsystem.JMS.controller;

import edu.miu.ea.sandesh.ordermanagementsystem.JMS.entity.OrderInfo;
import edu.miu.ea.sandesh.ordermanagementsystem.JMS.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController()
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private Producer producer;

    @GetMapping(path = "/orders")
    public OrderInfo getOrders() {
        OrderInfo orderInfo = new OrderInfo(1L, LocalDateTime.now().minusDays(3), 25.30);
        producer.sendOrder(orderInfo);
        return orderInfo;
    }


}
