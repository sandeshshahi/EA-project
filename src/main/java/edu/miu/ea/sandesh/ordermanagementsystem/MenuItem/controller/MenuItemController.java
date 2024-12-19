package edu.miu.ea.sandesh.ordermanagementsystem.MenuItem.controller;

import edu.miu.ea.sandesh.ordermanagementsystem.MenuItem.entity.MenuItem;
import edu.miu.ea.sandesh.ordermanagementsystem.MenuItem.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {
    @Autowired
    private MenuItemService menuItemService;

    @GetMapping("/restaurant/{restaurantId}")
    public List<MenuItem> getMenuItemsByRestaurantId(@PathVariable Long restaurantId) {
        return menuItemService.getMenuItemsByRestaurantId(restaurantId);
    }

}
