package com.si.activities.server.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.si.activities.server.domain.User;


public interface UserRepository extends JpaRepository<User, Integer> {
  User findByNickname(String nickname);
  
  User findByEmail(String email);

  Set<User> findByCourse_Id(Integer courseId);

  Set<User> findBySubjects_Id(Integer subjectId);
}
