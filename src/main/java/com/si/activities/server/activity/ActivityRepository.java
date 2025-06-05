package com.si.activities.server.activity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
  List<Activity> findBySchoolClassId(Integer id);
}
