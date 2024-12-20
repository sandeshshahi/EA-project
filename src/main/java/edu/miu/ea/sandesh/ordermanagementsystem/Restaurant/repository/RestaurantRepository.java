package edu.miu.ea.sandesh.ordermanagementsystem.Restaurant.repository;

import edu.miu.ea.sandesh.ordermanagementsystem.Restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Restaurant findByName(String name);

    Restaurant findTopRestaurantByOrderByNameAsc();

}
