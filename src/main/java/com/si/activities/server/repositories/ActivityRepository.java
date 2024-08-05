package com.si.activities.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.si.activities.server.domain.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {

}
