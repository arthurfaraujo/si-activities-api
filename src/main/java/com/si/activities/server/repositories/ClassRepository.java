package com.si.activities.server.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.si.activities.server.domain.Class;

public interface ClassRepository extends JpaRepository<Class, Integer> {
  List<Class> findBySubject_id(Integer id);
}
