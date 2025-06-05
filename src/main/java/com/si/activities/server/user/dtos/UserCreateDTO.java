package com.si.activities.server.user.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserCreateDTO(Integer id, @NotBlank String name, @NotBlank String nickname, @NotBlank String email, @NotBlank String password) {
  
}
