package edu.miu.ea.sandesh.ordermanagementsystem.Auth.service;

import edu.miu.ea.sandesh.ordermanagementsystem.Auth.dto.LoginDto;
import edu.miu.ea.sandesh.ordermanagementsystem.Auth.dto.RegistrationDto;
import edu.miu.ea.sandesh.ordermanagementsystem.Auth.dto.TokenDto;
import edu.miu.ea.sandesh.ordermanagementsystem.Common.Exception.ForbiddenException;
import edu.miu.ea.sandesh.ordermanagementsystem.Common.Exception.NotFoundException;
import edu.miu.ea.sandesh.ordermanagementsystem.Security.JwtHelper;
import edu.miu.ea.sandesh.ordermanagementsystem.User.UserRole;
import edu.miu.ea.sandesh.ordermanagementsystem.User.entity.User;
import edu.miu.ea.sandesh.ordermanagementsystem.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public TokenDto getToken(LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getEmail());
        if (user == null) {
            throw new NotFoundException("User not found");
        }
        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new ForbiddenException("Wrong password");
        }
        String token = jwtHelper.generateToken(user);
        return new TokenDto(token);
    }

    public User register(RegistrationDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setUserRole(UserRole.ROLE_CUSTOMER);
        return userRepository.save(user);
    }
}
