package com.si.activities.server.services;

import java.util.List;

import com.si.activities.server.dtos.SubjectDTO;
import com.si.activities.server.dtos.mapper.SubjectMapper;
import org.springframework.stereotype.Service;

import com.si.activities.server.repositories.SubjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubjectService {
  private final SubjectRepository repo;
  private final SubjectMapper subjectMapper;

  public SubjectDTO getById(Integer id) {
    return subjectMapper.toDTO(repo.getReferenceById(id));
  }

  public List<SubjectDTO> getAll() {
    return repo.findAll().stream().map(subjectMapper::toDTO).toList();
  }

  public Integer create(SubjectDTO subject) {
    return repo.save(subjectMapper.toEntity(subject)).getId();
  }
}
