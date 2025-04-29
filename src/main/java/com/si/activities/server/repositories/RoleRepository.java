package com.si.activities.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.si.activities.server.domain.Role;


public interface RoleRepository extends JpaRepository<Role, Integer> {
  Role findRoleByDescription(String description);
}
