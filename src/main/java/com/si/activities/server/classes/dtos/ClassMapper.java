package com.si.activities.server.classes.dtos;

import com.si.activities.server.classes.Class;
import com.si.activities.server.subject.Subject;
import com.si.activities.server.subject.dtos.SubjectMapper;
import com.si.activities.server.subject.SubjectService;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClassMapper {
  private final SubjectMapper subjectMapper;
  private final SubjectService subjectService;

  public ClassDTO toDTO(@NotNull Class entity) {
    return new ClassDTO(
        entity.getId(),
        entity.getReferencePeriod(),
        subjectMapper.toDTO(entity.getSubject()));
  }

  public Class toEntity(@NotNull ClassCreateDTO dto) {
    Subject subject = subjectService.getEntityById(dto.subjectId());

    Class classEntity = new Class();
    classEntity.setReferencePeriod(dto.referencePeriod());
    classEntity.setSubject(subject);

    return classEntity;
  }
}
