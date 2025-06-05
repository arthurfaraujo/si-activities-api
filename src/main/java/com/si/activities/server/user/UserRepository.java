package com.si.activities.server.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
  User findByNickname(String nickname);
  
  User findByEmail(String email);

  List<User> findAllByCourseId(Integer courseId);
}
