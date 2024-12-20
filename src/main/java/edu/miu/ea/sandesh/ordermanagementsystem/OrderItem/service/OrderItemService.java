package edu.miu.ea.sandesh.ordermanagementsystem.OrderItem.service;

import edu.miu.ea.sandesh.ordermanagementsystem.Common.Exception.NotFoundException;
import edu.miu.ea.sandesh.ordermanagementsystem.OrderItem.entity.OrderItem;
import edu.miu.ea.sandesh.ordermanagementsystem.OrderItem.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public OrderItem findOrderItemById(long id) {
        return orderItemRepository.findById(id).orElseThrow(() -> new NotFoundException("Order Item with id " + id + " not found"));
    }

    public List<OrderItem> findAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem updateOrderItem(long id, OrderItem orderItem) {
        Optional<OrderItem> orderItemOptional = orderItemRepository.findById(id);
        if (orderItemOptional.isPresent()) {
            OrderItem orderItemToUpdate = orderItemOptional.get();
            orderItemToUpdate.setQuantity(orderItem.getQuantity());
            orderItemToUpdate.setMenuItem(orderItem.getMenuItem());
            orderItemToUpdate.setUnitPrice(orderItem.getUnitPrice());
            orderItemToUpdate.setOrder(orderItem.getOrder());
            return orderItemRepository.save(orderItemToUpdate);
        }

        throw new NotFoundException("OrderItem with id " + id + " not found");
    }

    public void deleteOrderItem(long id) {
        orderItemRepository.deleteById(id);
    }

    public List<OrderItem> findOrderItemByOrderId(long id) {
        return orderItemRepository.findOrderItemsByOrderId(id);
    }
}
