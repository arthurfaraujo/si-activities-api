package com.si.activities.server.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.si.activities.server.domain.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
  List<Activity> findBySchoolClassId(Integer id);
}
