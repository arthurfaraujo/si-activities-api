package com.si.activities.server.user.dtos;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationTryDTO(@NotBlank String nickname, @NotBlank String password) {}
