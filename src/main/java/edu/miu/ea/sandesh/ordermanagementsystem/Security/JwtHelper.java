package edu.miu.ea.sandesh.ordermanagementsystem.Security;

import edu.miu.ea.sandesh.ordermanagementsystem.User.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtHelper {
    @Value("${application.jwt.secret}")
    private String secret;

    public String generateToken(User user) {
        return Jwts.builder()
                .subject(user.getEmail())
                .issuedAt(new Date())
                .claim("role", user.getUserRole().name())
                .signWith(getSecretKey())
                .compact();
    }

    public String generateToken(Principal principal) {
        String role = principal.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
        return Jwts.builder()
                .subject(principal.getUsername())
                .issuedAt(new Date())
                .claim("role", role)
                .signWith(getSecretKey())
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().verifyWith(getSecretKey()).build().parse(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Principal getUserPrincipal(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return new Principal(claims.getSubject(), "", claims.get("role", String.class));
    }

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }
}
