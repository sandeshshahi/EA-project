package edu.miu.ea.sandesh.ordermanagementsystem.User.service;

import edu.miu.ea.sandesh.ordermanagementsystem.Common.Exception.NotFoundException;
import edu.miu.ea.sandesh.ordermanagementsystem.User.entity.User;
import edu.miu.ea.sandesh.ordermanagementsystem.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User updateUser(Long id, User user) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User updatedUser = userOptional.get();
            updatedUser.setName(user.getName());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPassword(passwordEncoder.encode(user.getPassword()));
            updatedUser.setPhoneNumber(user.getPhoneNumber());
            updatedUser.setAddress(user.getAddress());
            updatedUser.setUserRole(user.getUserRole());
            return userRepository.save(updatedUser);
        }
        throw new NotFoundException("User with id " + id + " not found");
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> findAllUsersByRestaurantId(Long restaurantId) {
        return userRepository.findUsersByRestaurant(restaurantId);
    }


}
