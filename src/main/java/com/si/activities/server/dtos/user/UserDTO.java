package com.si.activities.server.dtos.user;

import java.util.Set;

import com.si.activities.server.domain.Role;

import jakarta.validation.constraints.NotBlank;

public record UserDTO(Integer id, @NotBlank String name, @NotBlank String nickname, Set<Role> roles) {
}
