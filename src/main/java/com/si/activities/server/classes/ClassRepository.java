package com.si.activities.server.classes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Class, Integer> {
  List<Class> findAllBySubjectId(Integer id);

  List<Class> findAllByUsersId(Integer id);
}
