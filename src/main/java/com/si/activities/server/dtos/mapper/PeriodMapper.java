package com.si.activities.server.dtos.mapper;

import com.si.activities.server.dtos.Period;
import org.springframework.stereotype.Component;

@Component
public class PeriodMapper {
  public Period toDTO(com.si.activities.server.domain.Period p) {
    return new Period(p.getId(), p.getDescription());
  }

  public com.si.activities.server.domain.Period toEntity(Period pr) {
    com.si.activities.server.domain.Period p = new com.si.activities.server.domain.Period();
    p.setDescription(pr.description());
    return p;
  }
}
