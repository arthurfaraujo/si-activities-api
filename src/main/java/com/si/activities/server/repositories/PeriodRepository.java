package com.si.activities.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.si.activities.server.domain.Period;

public interface PeriodRepository extends JpaRepository<Period, Integer> {

}
