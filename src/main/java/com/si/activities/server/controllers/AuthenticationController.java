package com.si.activities.server.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.si.activities.server.domain.User;
import com.si.activities.server.dtos.user.Authentication;
import com.si.activities.server.dtos.user.AuthenticationResponse;
import com.si.activities.server.dtos.user.UserDTO;
import com.si.activities.server.services.TokenService;
import com.si.activities.server.services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationManager authManager;
  private final UserService userService;
  private final TokenService tokenService;

  @PostMapping("/signin")
  public ResponseEntity<AuthenticationResponse> signIn(@RequestBody @Valid Authentication auth) {
    var authData = new UsernamePasswordAuthenticationToken(auth.nickname(), auth.password());
    org.springframework.security.core.Authentication authResp;

    try {
      authResp = authManager.authenticate(authData);
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }

    String token = tokenService.generateToken((User) authResp.getPrincipal());
    return ResponseEntity.ok(new AuthenticationResponse(token));
  }

  @PostMapping("/signup")
  @ResponseStatus(code = HttpStatus.CREATED)
  public UserDTO signUp(@RequestBody @Valid UserDTO auth) {
    UserDTO newUser = userService.create(auth).get();

    return newUser;
  }
}
