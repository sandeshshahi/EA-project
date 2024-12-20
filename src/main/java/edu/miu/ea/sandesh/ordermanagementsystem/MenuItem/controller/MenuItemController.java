package edu.miu.ea.sandesh.ordermanagementsystem.MenuItem.controller;

import edu.miu.ea.sandesh.ordermanagementsystem.MenuItem.entity.MenuItem;
import edu.miu.ea.sandesh.ordermanagementsystem.MenuItem.service.MenuItemService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {
    @Autowired
    private MenuItemService menuItemService;

    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CUSTOMER','ROLE_RESTAURANT_OWNER')")
    @GetMapping("/restaurant/{restaurantId}")
    public List<MenuItem> getMenuItemsByRestaurantId(@PathVariable Long restaurantId) {
        return menuItemService.getMenuItemsByRestaurantId(restaurantId);
    }

    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_RESTAURANT_OWNER')")
    @PostMapping()
    public MenuItem createMenuItem(@RequestBody MenuItem menuItem) {
        return menuItemService.createMenu(menuItem);
    }

    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_RESTAURANT_OWNER')")
    @PutMapping("/{id}")
    public MenuItem updateMenuItem(@PathVariable Long id, @RequestBody MenuItem menuItem) {
        return menuItemService.updateMenu(id, menuItem);
    }

    @SecurityRequirement(name = "auth")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_RESTAURANT_OWNER')")
    @DeleteMapping("/{id}")
    public void deleteMenuItem(@PathVariable Long id) {
        menuItemService.deleteMenu(id);
    }

}
