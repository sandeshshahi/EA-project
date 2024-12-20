package edu.miu.ea.sandesh.ordermanagementsystem.User.controller;

import edu.miu.ea.sandesh.ordermanagementsystem.User.entity.User;
import edu.miu.ea.sandesh.ordermanagementsystem.User.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    
    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/by-restaurant")
    public List<User> getUsersByRestaurant(Long restaurantId) {
        return userService.findAllUsersByRestaurantId(restaurantId);
    }
}
