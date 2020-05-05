package com.airplane.airplane_admin.token;

import com.airplane.airplane_admin.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

public class JwtUtil {
    public static String createToken(User user) {
        try {
            String token = JWT.create().withAudience(user.getUsername()).sign(Algorithm.HMAC256(user.getPassWord()));
            return token;
        } catch (JWTCreationException e) {
            e.printStackTrace();
            return null;
        }
    }
}
