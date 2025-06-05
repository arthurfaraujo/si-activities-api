package com.si.activities.server.classes;

import java.util.List;

import org.springframework.stereotype.Service;
import com.si.activities.server.classes.dtos.ClassCreateDTO;
import com.si.activities.server.classes.dtos.ClassDTO;
import com.si.activities.server.classes.dtos.ClassMapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClassService {

  private final ClassRepository repo;
  private final ClassMapper mapper;

  public ClassDTO getById(Integer id) {
    return mapper.toDTO(repo.findById(id).orElseThrow(() -> {
      return new EntityNotFoundException("Class not found with id: " + id);
    }));
  }

  public Class getEntityById(Integer id) {
    return repo.getReferenceById(id);
  }

  public List<ClassDTO> getAllBySubjectId(Integer id) {
    return repo.findAllBySubjectId(id).stream().map(mapper::toDTO).toList();
  }

  public List<ClassDTO> getAllByUserId(Integer id) {
    return repo.findAllByUsersId(id).stream().map(mapper::toDTO).toList();
  }

  public ClassDTO create(ClassCreateDTO newClass) {
    return mapper.toDTO(repo.save(mapper.toEntity(newClass)));
  }
}
