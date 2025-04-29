package com.si.activities.server.config.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.si.activities.server.services.TokenService;
import com.si.activities.server.services.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {
  /* class responsible for adding the user auth info
   to the security context, that way the application
   knows the user is logged in */

  private final TokenService tokenService;
  private final UserService userService;

  private String recoverToken(HttpServletRequest req) {
    String authHeader = req.getHeader("Authorization");
    return authHeader == null ? null : authHeader.replace("Bearer ", "");
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    String token = recoverToken(request);

    if (token != null) {
      String nickname = tokenService.validateToken(token);
      UserDetails user = userService.loadUserByUsername(nickname);

      var auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

      SecurityContextHolder.getContext().setAuthentication(auth);
    }

    filterChain.doFilter(request, response);
  }
}
