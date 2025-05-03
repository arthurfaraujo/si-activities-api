package com.si.activities.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.si.activities.server.domain.User;


public interface UserRepository extends JpaRepository<User, Integer> {
  User findByNickname(String nickname);
  User findByEmail(String email);
}
