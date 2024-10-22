package com.si.activities.server.services;

import com.si.activities.server.domain.Period;
import com.si.activities.server.repositories.PeriodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PeriodService {
  private final PeriodRepository repo;

  private List<Period> getALl() {
    return repo.findAll();
  }
}
