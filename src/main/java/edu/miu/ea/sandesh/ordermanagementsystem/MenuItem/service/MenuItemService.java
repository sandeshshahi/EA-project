package edu.miu.ea.sandesh.ordermanagementsystem.MenuItem.service;

import edu.miu.ea.sandesh.ordermanagementsystem.Common.Exception.NotFoundException;
import edu.miu.ea.sandesh.ordermanagementsystem.MenuItem.entity.MenuItem;
import edu.miu.ea.sandesh.ordermanagementsystem.MenuItem.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuItemService {
    @Autowired
    private MenuItemRepository menuItemRepository;

    public MenuItem createMenu(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    public List<MenuItem> findAllMenu() {
        return menuItemRepository.findAll();
    }

    public MenuItem findMenuItemById(Long id) {
        return menuItemRepository.findById(id).orElseThrow(() -> new NotFoundException("MenuItem with id " + id + " not found"));
    }

    public MenuItem updateMenu(Long id, MenuItem menuItem) {
        Optional<MenuItem> item = menuItemRepository.findById(id);
        if (item.isPresent()) {
            MenuItem existingItem = menuItemRepository.findById(id).get();
            existingItem.setName(menuItem.getName());
            existingItem.setDescription(menuItem.getDescription());
            existingItem.setPrice(menuItem.getPrice());
            existingItem.setAvailability(menuItem.getAvailability());
            return menuItemRepository.save(existingItem);
        }
        throw new NotFoundException("Menu Item with id " + id + " not found");
    }

    public void deleteMenu(Long id) {
        menuItemRepository.deleteById(id);
    }

    public List<MenuItem> getMenuItemsByRestaurantId(Long restaurantId) {
        return menuItemRepository.findMenuItemByRestaurantId(restaurantId);
    }
}
