package com.si.activities.server.user.dtos;

import java.util.Set;

import com.si.activities.server.role.Role;

import jakarta.validation.constraints.NotBlank;

public record UserDTO(Integer id, @NotBlank String name, @NotBlank String nickname, Set<Role> roles) {
}
