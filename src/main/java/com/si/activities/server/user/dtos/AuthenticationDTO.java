package com.si.activities.server.user.dtos;

public record AuthenticationDTO(UserDTO user, String token) {
  
}
