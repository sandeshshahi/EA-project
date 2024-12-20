package edu.miu.ea.sandesh.ordermanagementsystem.User.service;

import edu.miu.ea.sandesh.ordermanagementsystem.User.entity.User;
import edu.miu.ea.sandesh.ordermanagementsystem.User.repository.UserRepository;
import edu.miu.ea.sandesh.ordermanagementsystem.common.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
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
            updatedUser.setPassword(user.getPassword());
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


}
