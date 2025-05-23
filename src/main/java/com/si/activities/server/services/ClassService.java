package com.si.activities.server.services;

import org.springframework.stereotype.Service;

import com.si.activities.server.domain.Class;

import com.si.activities.server.repositories.ClassRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClassService {
  private final ClassRepository repo;

  public Class getById(Integer id) {
    var found = repo.findById(id);
    if (found.isPresent()) {
      return found.get();
    }

    throw new RuntimeException("Class not found with id: " + id);
  }
  
  public Class getEntityById(Integer id) {
    return repo.getReferenceById(id);
  }
}
