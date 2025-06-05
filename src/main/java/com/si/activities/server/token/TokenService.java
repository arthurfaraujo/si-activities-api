package com.si.activities.server.token;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.si.activities.server.user.User;

@Service
public class TokenService {

  @Value("${api.security.secret}")
  private String secret;

  public String generateToken(User user) {
    return new Token(secret, user).getValue();
  }

  public String verifyToken(String token) {
    return new Token(secret, token).getSubject();
  }
}