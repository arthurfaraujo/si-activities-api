package com.si.activities.server.subject;

import java.util.List;

import com.si.activities.server.subject.dtos.SubjectMapper;
import com.si.activities.server.course.CourseService;
import com.si.activities.server.subject.dtos.SubjectCreateDTO;
import com.si.activities.server.subject.dtos.SubjectDTO;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class SubjectService {
  private final SubjectRepository repo;
  private final SubjectMapper subjectMapper;
  private final CourseService courseService;

  public SubjectDTO getById(Integer id) {
    //TODO: return dedicated exception class
    return repo.findById(id).map(subjectMapper::toDTO).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Subject not found"));
  }

  public Subject getEntityById(Integer id) {
    return repo.getReferenceById(id);
  }

  public List<SubjectDTO> getAll() {
    return repo.findAll().stream().map(subjectMapper::toDTO).toList();
  }

  public List<SubjectDTO> getAllByCourseId(Integer id) {
    return repo.findAllByCourseId(id).stream().map(subjectMapper::toDTO).toList();
  }

  public Integer create(SubjectCreateDTO subject) throws ResponseStatusException {
    if (subject.period() > 0 && subject.period() <= courseService.getPeriodsNumberById(subject.courseId())) {
      return repo.save(subjectMapper.toEntity(subject)).getId();
    }
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Period bigger than selected course number of periods");
  }
}
