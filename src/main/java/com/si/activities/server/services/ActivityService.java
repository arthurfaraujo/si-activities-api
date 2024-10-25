package com.si.activities.server.services;

import java.util.List;

import com.si.activities.server.dtos.mapper.ActivityMapper;
import com.si.activities.server.dtos.mapper.SubjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.si.activities.server.domain.Activity;
import com.si.activities.server.domain.Subject;
import com.si.activities.server.dtos.ActivityRequest;
import com.si.activities.server.dtos.ActivityResponse;
import com.si.activities.server.repositories.ActivityRepository;
import com.si.activities.server.repositories.SubjectRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ActivityService {
  private final ActivityRepository repo;
  private final SubjectRepository subjectRepo;
  private final ActivityMapper activityMapper;

  public ActivityResponse getById(Integer id) {
    return repo.findById(id).map(activityMapper::toDTO).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found"));
  }

  public List<ActivityResponse> getAll() {
    return repo.findAll().stream().map(activityMapper::toDTO).toList();
  }

  public Integer create(ActivityRequest newActivity) {
    return repo.save(activityMapper.toEntity(newActivity)).getId();
  }
}
