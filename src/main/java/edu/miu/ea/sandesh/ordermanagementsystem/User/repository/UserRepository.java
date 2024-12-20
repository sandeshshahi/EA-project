package edu.miu.ea.sandesh.ordermanagementsystem.User.repository;

import edu.miu.ea.sandesh.ordermanagementsystem.User.entity.User;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    //    Find all users who have placed orders at a specific restaurant
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT DISTINCT o.user FROM Order o WHERE o.restaurant.id = :restaurantId")
    List<User> findUsersByRestaurant(@Param("restaurantId") Long restaurantId);

}
