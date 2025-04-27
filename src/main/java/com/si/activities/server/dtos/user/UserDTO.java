package com.si.activities.server.dtos.user;

import jakarta.validation.constraints.NotBlank;

public record UserDTO(Integer id, @NotBlank String name, @NotBlank String nickname, @NotBlank String email, @NotBlank String password) {
  
}
