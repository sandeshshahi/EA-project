package edu.miu.ea.sandesh.ordermanagementsystem.MenuItem.repository;

import edu.miu.ea.sandesh.ordermanagementsystem.MenuItem.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

    @Query("SELECT m FROM MenuItem m WHERE m.restaurant.id = :restaurantId")
    List<MenuItem> findMenuItemByRestaurantId(Long restaurantId);
}
