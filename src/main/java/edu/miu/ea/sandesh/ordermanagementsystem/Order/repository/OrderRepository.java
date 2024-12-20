package edu.miu.ea.sandesh.ordermanagementsystem.Order.repository;

import edu.miu.ea.sandesh.ordermanagementsystem.Order.Status;
import edu.miu.ea.sandesh.ordermanagementsystem.Order.entity.Order;
import edu.miu.ea.sandesh.ordermanagementsystem.Restaurant.entity.Restaurant;
import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {


    @Query(name = "Order.findRestaurantByOrderId")
    Restaurant findRestaurantByOrderId(@Param("orderId") Long orderId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<Order> findByRestaurantId(Long restaurantId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<Order> findByOrderStatus(Status orderStatus);

    //    Find all orders by a specific user and restaurant
    @Query("SELECT o FROM Order o WHERE o.user.id = :userId AND o.restaurant.id = :restaurantId")
    List<Order> findOrdersByUserAndRestaurant(@Param("userId") Long userId, @Param("restaurantId") Long restaurantId);

}
