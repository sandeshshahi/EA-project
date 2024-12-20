package edu.miu.ea.sandesh.ordermanagementsystem.JMS.producer;

import edu.miu.ea.sandesh.ordermanagementsystem.JMS.entity.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Producer {
    @Value("${springjms.queueName}")
    private String queueName;

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendOrder(OrderInfo orderInfo) {
        System.out.println("Sending order info: " + orderInfo);
        Map map = new HashMap();
        map.put("id", orderInfo.getId());
        map.put("orderDate", orderInfo.getOrderDate().toString());
        map.put("totalPrice", orderInfo.getTotalPrice());
        jmsTemplate.convertAndSend(queueName, map);
    }
}
