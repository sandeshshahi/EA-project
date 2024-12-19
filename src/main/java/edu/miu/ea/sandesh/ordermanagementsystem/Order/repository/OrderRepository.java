package edu.miu.ea.sandesh.ordermanagementsystem.Order.repository;

import edu.miu.ea.sandesh.ordermanagementsystem.Order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
