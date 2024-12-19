package edu.miu.ea.sandesh.ordermanagementsystem.Restaurant.controller;

import edu.miu.ea.sandesh.ordermanagementsystem.Restaurant.entity.Restaurant;
import edu.miu.ea.sandesh.ordermanagementsystem.Restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping()
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id);
    }

    @GetMapping("/by-name")
    public Restaurant getRestaurantByName(@RequestParam String name) {
        return restaurantService.getRestaurantByName(name);
    }

    @GetMapping("/highest-rated")
    public Restaurant getRestaurantByHighestRating() {
        return restaurantService.getRestaurantByHighestRating();
    }

    @PostMapping()
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.createRestaurant(restaurant);
    }

    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurant) {
        return restaurantService.updateRestaurant(id, restaurant);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
    }
}
