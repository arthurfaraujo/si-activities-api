package com.si.activities.server.token;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.si.activities.server.user.User;

public class Token {
  private String token;
  private String subject;
  private String secret;

  public Token(String secret, String token) {
    this.secret = secret;

    this.subject = validate(token);
    this.token = token;
  }

  public Token(String secret, User user) {
    this.token = generateToken(user);
  }

  public String getSubject() {
    return subject;
  }

  public String getValue() {
    return token;
  }

  private String validate(String token) {
    Algorithm algorithm = Algorithm.HMAC256(secret);

    try {
      return JWT.require(algorithm)
          .withIssuer("si-activities-api")
          .build()
          .verify(token).getSubject();
    } catch (JWTVerificationException e) {
      return "";
    }
  }

  public String generateToken(User user) {
    Algorithm algorithm = Algorithm.HMAC256(secret);

    try {
      return JWT.create()
          .withIssuer("si-activities-api")
          .withSubject(user.getNickname())
          .withExpiresAt(generateExpiresAt())
          .sign(algorithm);
    } catch (JWTCreationException e) {
      throw new RuntimeException("Error while generating token", e);
    }
  }
  
  private Instant generateExpiresAt() {
    return LocalDateTime.now().plusHours(8).toInstant(ZoneOffset.of("-03:00"));
  }
}
