package edu.miu.ea.sandesh.ordermanagementsystem.Auth.dto;

public class TokenDto {
    private final String token;

    public TokenDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
