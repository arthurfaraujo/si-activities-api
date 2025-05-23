package com.si.activities.server.dtos.user;

public record AuthenticationDTO(UserDTO user, String token) {
  
}
