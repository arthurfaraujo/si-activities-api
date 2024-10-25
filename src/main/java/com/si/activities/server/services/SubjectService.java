package com.si.activities.server.services;

import java.util.List;

import com.si.activities.server.domain.Subject;
import com.si.activities.server.dtos.SubjectRequest;
import com.si.activities.server.dtos.SubjectResponse;
import com.si.activities.server.dtos.mapper.SubjectMapper;
import org.springframework.stereotype.Service;

import com.si.activities.server.repositories.SubjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubjectService {
  private final SubjectRepository repo;
  private final SubjectMapper subjectMapper;

  public SubjectResponse getById(Integer id) {
    return subjectMapper.toDTO(repo.getReferenceById(id));
  }

  public Subject getEntityById(Integer id) {
    return repo.getReferenceById(id);
  }

  public List<SubjectResponse> getAll() {
    return repo.findAll().stream().map(subjectMapper::toDTO).toList();
  }

  public Integer create(SubjectRequest subject) {
    return repo.save(subjectMapper.toEntity(subject)).getId();
  }
}
