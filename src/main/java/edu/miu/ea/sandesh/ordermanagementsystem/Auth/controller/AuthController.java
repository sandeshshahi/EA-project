package edu.miu.ea.sandesh.ordermanagementsystem.Auth.controller;

import edu.miu.ea.sandesh.ordermanagementsystem.Auth.dto.LoginDto;
import edu.miu.ea.sandesh.ordermanagementsystem.Auth.dto.RegistrationDto;
import edu.miu.ea.sandesh.ordermanagementsystem.Auth.dto.TokenDto;
import edu.miu.ea.sandesh.ordermanagementsystem.Auth.service.AuthService;
import edu.miu.ea.sandesh.ordermanagementsystem.User.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public TokenDto login(@RequestBody LoginDto loginDto) {
        return this.authService.getToken(loginDto);
    }

    @PostMapping("/register")
    public User register(@RequestBody RegistrationDto registrationDto) {
        return this.authService.register(registrationDto);
    }
}
