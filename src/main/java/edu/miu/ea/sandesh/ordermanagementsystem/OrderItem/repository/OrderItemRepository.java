package edu.miu.ea.sandesh.ordermanagementsystem.OrderItem.repository;

import edu.miu.ea.sandesh.ordermanagementsystem.OrderItem.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
