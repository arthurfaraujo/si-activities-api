package com.si.activities.server.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.si.activities.server.domain.Subject;
import com.si.activities.server.repositories.SubjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubjectService {
  private final SubjectRepository repo;

  public Subject getById(Integer id) {
    return repo.getReferenceById(id);
  }

  public List<Subject> getAll() {
    return repo.findAll();
  }

  public Integer create(Subject subject) {
    repo.save(subject);

    return subject.getId();
  }
}
