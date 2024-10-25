package com.si.activities.server.services;

import java.util.List;

import com.si.activities.server.domain.Subject;
import com.si.activities.server.dtos.SubjectRequest;
import com.si.activities.server.dtos.SubjectResponse;
import com.si.activities.server.dtos.mapper.SubjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.si.activities.server.repositories.SubjectRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class SubjectService {
  private final SubjectRepository repo;
  private final SubjectMapper subjectMapper;
  private final CourseService courseService;

  public SubjectResponse getById(Integer id) {
    return repo.findById(id).map(subjectMapper::toDTO).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Subject not found"));
  }

  public Subject getEntityById(Integer id) {
    return repo.getReferenceById(id);
  }

  public List<SubjectResponse> getAll() {
    return repo.findAll().stream().map(subjectMapper::toDTO).toList();
  }

  public Integer create(SubjectRequest subject) throws ResponseStatusException {
    if (subject.period() > 0 && subject.period() <= courseService.getPeriodsNumberById(subject.courseId())) {
      return repo.save(subjectMapper.toEntity(subject)).getId();
    }
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Period bigger than selected course number of periods");
  }
}
