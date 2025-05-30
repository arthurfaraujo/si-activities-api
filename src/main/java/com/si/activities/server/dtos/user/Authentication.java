package com.si.activities.server.dtos.user;

import jakarta.validation.constraints.NotBlank;

public record Authentication(@NotBlank String nickname, @NotBlank String password) {
  
}
