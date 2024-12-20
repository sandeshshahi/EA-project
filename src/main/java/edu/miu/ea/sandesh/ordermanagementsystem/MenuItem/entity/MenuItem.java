package edu.miu.ea.sandesh.ordermanagementsystem.MenuItem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.miu.ea.sandesh.ordermanagementsystem.MenuItem.Availability;
import edu.miu.ea.sandesh.ordermanagementsystem.Restaurant.entity.Restaurant;
import jakarta.persistence.*;

@Entity
@NamedQuery(
        name = "MenuItem.findMenuItemByRestaurantId",
        query = "SELECT m FROM MenuItem m WHERE m.restaurant.id = :restaurantId"
)
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;

    @Enumerated(EnumType.STRING)
    private Availability availability;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Version
    private Long version;

    public MenuItem() {
    }

    public MenuItem(String name, String description, Double price, Availability availability, Restaurant restaurant) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.availability = availability;
        this.restaurant = restaurant;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
