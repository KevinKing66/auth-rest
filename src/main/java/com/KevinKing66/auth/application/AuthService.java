package com.KevinKing66.auth.application;

import com.KevinKing66.auth.domain.User;
import com.KevinKing66.auth.domain.port.UserRepository;
import com.KevinKing66.auth.shared.utils.DateHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;

/**
 *
 * @author kevin
 */
@Service
public class AuthService {

    private final UserRepository userRepository;

    private final Key signingKey;


    public AuthService(UserRepository userRepository, @Value("${jwt.secret}") String secretKey) {
        this.userRepository = userRepository;
        this.signingKey = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String autenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return generateToken(user);
        }
        throw new RuntimeException("Invalid credebtials");
    }

    private String generateToken(User user) {
        return Jwts.builder().
                setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + DateHelper.addHoursToCurrentTimeInMs(24)))
                .signWith(signingKey, SignatureAlgorithm.HS256)
                .compact();
    }
    
}
