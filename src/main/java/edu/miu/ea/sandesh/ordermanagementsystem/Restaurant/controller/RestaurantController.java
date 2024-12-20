package edu.miu.ea.sandesh.ordermanagementsystem.Restaurant.controller;

import edu.miu.ea.sandesh.ordermanagementsystem.Restaurant.entity.Restaurant;
import edu.miu.ea.sandesh.ordermanagementsystem.Restaurant.service.RestaurantService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id);
    }

    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    @GetMapping("/by-name")
    public Restaurant getRestaurantByName(@RequestParam String name) {
        return restaurantService.getRestaurantByName(name);
    }

    @GetMapping("/highest-rated")
    public Restaurant getRestaurantByHighestRating() {
        return restaurantService.getRestaurantByHighestRating();
    }

    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_RESTAURANT_OWNER')")
    @PostMapping()
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.createRestaurant(restaurant);
    }

    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_RESTAURANT_OWNER')")
    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurant) {
        return restaurantService.updateRestaurant(id, restaurant);
    }

    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_RESTAURANT_OWNER')")
    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
    }

    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CUSTOMER')")
    @GetMapping("/by-user")
    public List<Restaurant> getRestaurantsByUser(Long userId) {
        return restaurantService.getRestaurantsByUser(userId);
    }

}
