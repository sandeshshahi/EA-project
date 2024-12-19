package edu.miu.ea.sandesh.ordermanagementsystem.Restaurant.service;

import edu.miu.ea.sandesh.ordermanagementsystem.Restaurant.entity.Restaurant;
import edu.miu.ea.sandesh.ordermanagementsystem.Restaurant.repository.RestaurantRepository;
import edu.miu.ea.sandesh.ordermanagementsystem.common.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant getRestaurantByName(String name) {
        return restaurantRepository.findByName(name);
    }

    public Restaurant getRestaurantByHighestRating() {
        return restaurantRepository.findTopRestaurantByOrderByNameAsc();
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        return restaurant.orElseThrow(() -> new NotFoundException("Restaurant with id " + id + " not found"));
    }

    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            Restaurant updatedRestaurant = optionalRestaurant.get();
            updatedRestaurant.setName(restaurant.getName());
            updatedRestaurant.setAddress(restaurant.getAddress());
            updatedRestaurant.setPhoneNumber(restaurant.getPhoneNumber());
            updatedRestaurant.setRating(restaurant.getRating());
            updatedRestaurant.setMenuItems(restaurant.getMenuItems());
            return restaurantRepository.save(updatedRestaurant);
        }
        throw new NotFoundException("Restaurant with id " + id + " not found");
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}

