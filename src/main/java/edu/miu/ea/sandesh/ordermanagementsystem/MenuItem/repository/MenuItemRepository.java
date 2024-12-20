package edu.miu.ea.sandesh.ordermanagementsystem.MenuItem.repository;

import edu.miu.ea.sandesh.ordermanagementsystem.MenuItem.entity.MenuItem;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query(name = "MenuItem.findMenuItemByRestaurantId")
    List<MenuItem> findMenuItemByRestaurantId(Long restaurantId);
}
