package edu.miu.ea.sandesh.ordermanagementsystem.Restaurant.repository;

import edu.miu.ea.sandesh.ordermanagementsystem.Restaurant.entity.Restaurant;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Restaurant findByName(String name);

    Restaurant findTopRestaurantByOrderByNameAsc();

    //    Find all restaurants that a specific user has placed orders from
    @Query("SELECT DISTINCT o.restaurant FROM Order o WHERE o.user.id = :userId")
    List<Restaurant> findRestaurantsByUser(@Param("userId") Long userId);

}
