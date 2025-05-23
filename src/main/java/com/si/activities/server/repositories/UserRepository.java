package com.si.activities.server.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.si.activities.server.domain.User;


public interface UserRepository extends JpaRepository<User, Integer> {
  User findByNickname(String nickname);
  
  User findByEmail(String email);

  List<User> findAllByCourseId(Integer courseId);
}
