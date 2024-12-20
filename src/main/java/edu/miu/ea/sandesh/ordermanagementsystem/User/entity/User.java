package edu.miu.ea.sandesh.ordermanagementsystem.User.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.miu.ea.sandesh.ordermanagementsystem.Order.entity.Order;
import edu.miu.ea.sandesh.ordermanagementsystem.User.UserRole;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true, updatable = false)
    private String email;
    @JsonIgnore
    private String password;
    private String phoneNumber;
    private String address;
    private LocalDateTime registrationDate;
    private UserRole userRole;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @Version
    private Long version;
    
    public User() {
    }

    public User(String name, String email, String password, String phoneNumber, String address, LocalDateTime registrationDate, UserRole userRole) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.registrationDate = registrationDate;
        this.userRole = userRole;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
