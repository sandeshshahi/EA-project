package edu.miu.ea.sandesh.ordermanagementsystem.config;

import edu.miu.ea.sandesh.ordermanagementsystem.MenuItem.Availability;
import edu.miu.ea.sandesh.ordermanagementsystem.MenuItem.entity.MenuItem;
import edu.miu.ea.sandesh.ordermanagementsystem.MenuItem.service.MenuItemService;
import edu.miu.ea.sandesh.ordermanagementsystem.Order.Status;
import edu.miu.ea.sandesh.ordermanagementsystem.Order.entity.Order;
import edu.miu.ea.sandesh.ordermanagementsystem.Order.service.OrderService;
import edu.miu.ea.sandesh.ordermanagementsystem.OrderItem.entity.OrderItem;
import edu.miu.ea.sandesh.ordermanagementsystem.OrderItem.service.OrderItemService;
import edu.miu.ea.sandesh.ordermanagementsystem.Restaurant.entity.Restaurant;
import edu.miu.ea.sandesh.ordermanagementsystem.Restaurant.service.RestaurantService;
import edu.miu.ea.sandesh.ordermanagementsystem.User.UserRole;
import edu.miu.ea.sandesh.ordermanagementsystem.User.entity.User;
import edu.miu.ea.sandesh.ordermanagementsystem.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private MenuItemService menuItemService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        Restaurant restaurant1 = this.restaurantService.createRestaurant(new Restaurant(
                "Fairfield Khaja Ghar",
                "1000 North 4th Street",
                "982345678053",
                5.0));
        Restaurant restaurant2 = this.restaurantService.createRestaurant(new Restaurant("Savory Spoon",
                "123 Main Street, Springfield",
                "+1-417-304-2520",
                4.9));
        Restaurant restaurant3 = this.restaurantService.createRestaurant(new Restaurant("Golden Plate",
                "456 Elm Road, Riverdale",
                "+1-529-998-7443",
                1.2));
        Restaurant restaurant4 = this.restaurantService.createRestaurant(new Restaurant("The Hungry Fork",
                "789 Maple Avenue, Shelbyville",
                "+1-486-652-5191",
                1.6));
        Restaurant restaurant5 = this.restaurantService.createRestaurant(new Restaurant("Tasty Bites",
                "321 Oak Lane, Smallville",
                "+1-967-245-5675",
                3.6));
        Restaurant restaurant6 = this.restaurantService.createRestaurant(new Restaurant("Urban Feast",
                "654 Pine Blvd, Metropolis",
                "+1-792-164-7742",
                2.3));
        Restaurant restaurant7 = this.restaurantService.createRestaurant(new Restaurant("Flavorscape",
                "987 Birch Way, Gotham City",
                "+1-156-766-7775",
                4.1));

        MenuItem menuItem1 = this.menuItemService.createMenu(new MenuItem("Butter Chicken", "Rich and creamy chicken curry", 12.5, Availability.AVAILABLE, restaurant1));
        MenuItem menuItem2 = this.menuItemService.createMenu(new MenuItem("Garlic Naan", "Soft naan bread with garlic", 3.0, Availability.AVAILABLE, restaurant1));

        MenuItem menuItem3 = this.menuItemService.createMenu(new MenuItem("Chicken Parmesan", "Breaded chicken with marinara sauce", 15.0, Availability.AVAILABLE, restaurant1));
        MenuItem menuItem4 = this.menuItemService.createMenu(new MenuItem("Caesar Salad", "Fresh romaine lettuce with Caesar dressing", 8.0, Availability.AVAILABLE, restaurant2));

        MenuItem menuItem5 = this.menuItemService.createMenu(new MenuItem("Paneer Butter Masala", "Creamy paneer cooked in tomato gravy", 10.0, Availability.AVAILABLE, restaurant2));
        MenuItem menuItem6 = this.menuItemService.createMenu(new MenuItem("Chicken Tikka Masala", "Grilled chicken pieces in a spicy tomato sauce", 13.5, Availability.AVAILABLE, restaurant3));
        MenuItem menuItem7 = this.menuItemService.createMenu(new MenuItem("Lamb Biryani", "Fragrant basmati rice with tender lamb", 16.0, Availability.AVAILABLE, restaurant3));
        MenuItem menuItem8 = this.menuItemService.createMenu(new MenuItem("Samosa", "Crispy pastry filled with spiced potatoes and peas", 4.5, Availability.AVAILABLE, restaurant3));

        MenuItem menuItem9 = this.menuItemService.createMenu(new MenuItem("Spaghetti Bolognese", "Pasta with a rich meat sauce", 14.0, Availability.AVAILABLE, restaurant4));
        MenuItem menuItem10 = this.menuItemService.createMenu(new MenuItem("Margherita Pizza", "Classic pizza topped with tomatoes, mozzarella, and basil", 10.5, Availability.AVAILABLE, restaurant5));
        MenuItem menuItem11 = this.menuItemService.createMenu(new MenuItem("Grilled Salmon", "Fresh salmon fillet grilled with lemon and herbs", 18.0, Availability.AVAILABLE, restaurant6));
        MenuItem menuItem12 = this.menuItemService.createMenu(new MenuItem("Tiramisu", "Classic Italian dessert with layers of coffee-soaked cake and mascarpone", 6.5, Availability.AVAILABLE, restaurant7));

        MenuItem menuItem13 = this.menuItemService.createMenu(new MenuItem("Spaghetti Bolognese", "Pasta with a rich meat sauce", 14.0, Availability.AVAILABLE, restaurant7));
        MenuItem menuItem14 = this.menuItemService.createMenu(new MenuItem("Margherita Pizza", "Classic pizza topped with tomatoes, mozzarella, and basil", 10.5, Availability.AVAILABLE, restaurant7));
        MenuItem menuItem15 = this.menuItemService.createMenu(new MenuItem("Grilled Salmon", "Fresh salmon fillet grilled with lemon and herbs", 18.0, Availability.AVAILABLE, restaurant7));
        MenuItem menuItem16 = this.menuItemService.createMenu(new MenuItem("Tiramisu", "Classic Italian dessert with layers of coffee-soaked cake and mascarpone", 6.5, Availability.AVAILABLE, restaurant5));

        Order order1 = this.orderService.createOrder(new Order(LocalDateTime.now().minusDays(4), 22.5, Status.PLACED, restaurant1));
        Order order2 = this.orderService.createOrder(new Order(LocalDateTime.now().minusDays(2), 30.5, Status.PLACED, restaurant2));
        Order order3 = this.orderService.createOrder(new Order(LocalDateTime.now().minusDays(3), 40.0, Status.IN_PROGRESS, restaurant3));
        Order order4 = this.orderService.createOrder(new Order(LocalDateTime.now().minusDays(1), 10.5, Status.COMPLETED, restaurant4));
        Order order5 = this.orderService.createOrder(new Order(LocalDateTime.now().minusDays(5), 9.5, Status.PLACED, restaurant1));

        OrderItem orderItem1 = this.orderItemService.createOrderItem(new OrderItem(menuItem2, 2, menuItem2.getPrice(), order1));
        OrderItem orderItem2 = this.orderItemService.createOrderItem(new OrderItem(menuItem2, 1, menuItem2.getPrice(), order1));
        OrderItem orderItem3 = this.orderItemService.createOrderItem(new OrderItem(menuItem1, 2, menuItem1.getPrice(), order2));
        OrderItem orderItem4 = this.orderItemService.createOrderItem(new OrderItem(menuItem3, 3, menuItem3.getPrice(), order3));
        OrderItem orderItem5 = this.orderItemService.createOrderItem(new OrderItem(menuItem2, 1, menuItem2.getPrice(), order4));
        OrderItem orderItem6 = this.orderItemService.createOrderItem(new OrderItem(menuItem3, 1, menuItem3.getPrice(), order5));
        OrderItem orderItem7 = this.orderItemService.createOrderItem(new OrderItem(menuItem3, 1, menuItem3.getPrice(), order4));

        User user1 = this.userService.createUser(new User("John", "john@gmail.com", "abc123", "0987654321", "Fairfield", LocalDateTime.now(), UserRole.ADMIN));
        User user2 = this.userService.createUser(new User("Alice", "alice@gmail.com", "pass123", "1234567890", "New York", LocalDateTime.now().minusDays(10), UserRole.CUSTOMER));
        User user3 = this.userService.createUser(new User("Bob", "bob@gmail.com", "secure456", "2345678901", "Los Angeles", LocalDateTime.now().minusDays(15), UserRole.RESTAURANT_OWNER));
        User user4 = this.userService.createUser(new User("Eve", "eve@gmail.com", "eve789", "3456789012", "Chicago", LocalDateTime.now().minusDays(20), UserRole.ADMIN));
        User user5 = this.userService.createUser(new User("Charlie", "charlie@gmail.com", "charlie321", "4567890123", "Boston", LocalDateTime.now().minusDays(25), UserRole.CUSTOMER));


    }
}
