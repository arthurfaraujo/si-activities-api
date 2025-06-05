package com.si.activities.server.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.si.activities.server.token.TokenService;
import com.si.activities.server.user.dtos.AuthenticationDTO;
import com.si.activities.server.user.dtos.AuthenticationTryDTO;
import com.si.activities.server.user.dtos.UserCreateDTO;
import com.si.activities.server.user.dtos.UserDTO;

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
  public ResponseEntity<AuthenticationDTO> signIn(@RequestBody @Valid AuthenticationTryDTO auth) {
    var authData = new UsernamePasswordAuthenticationToken(auth.nickname(), auth.password());
    org.springframework.security.core.Authentication authResp;

    try {
      authResp = authManager.authenticate(authData);
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }

    User userAuth = (User) authResp.getPrincipal();
    String token = tokenService.generateToken(userAuth);

    return ResponseEntity.ok(new AuthenticationDTO(
        new UserDTO(userAuth.getId(), userAuth.getName(), userAuth.getNickname(), userAuth.getRoles()), token));
  }

  @PostMapping("/signup")
  public ResponseEntity<UserDTO> signUp(@RequestBody @Valid UserCreateDTO auth) {
    UserDTO newUser = userService.create(auth);

    if (newUser != null) {
      return new ResponseEntity<UserDTO>(newUser, HttpStatus.CREATED);
    }

    return ResponseEntity.badRequest().body(null);
  }
}
