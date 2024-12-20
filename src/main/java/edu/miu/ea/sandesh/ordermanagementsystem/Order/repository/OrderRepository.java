package edu.miu.ea.sandesh.ordermanagementsystem.Order.repository;

import edu.miu.ea.sandesh.ordermanagementsystem.Order.Status;
import edu.miu.ea.sandesh.ordermanagementsystem.Order.entity.Order;
import edu.miu.ea.sandesh.ordermanagementsystem.Restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


    @Query("SELECT o.restaurant FROM Order o WHERE o.id =:orderId")
    Restaurant findRestaurantByOrderId(@Param("orderId") Long orderId);


    List<Order> findByRestaurantId(Long restaurantId);

    List<Order> findByOrderStatus(Status orderStatus);
}
