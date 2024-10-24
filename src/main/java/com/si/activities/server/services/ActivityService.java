package com.si.activities.server.services;

import java.util.List;

import com.si.activities.server.dtos.mapper.ActivityMapper;
import com.si.activities.server.dtos.mapper.SubjectMapper;
import org.springframework.stereotype.Service;

import com.si.activities.server.domain.Activity;
import com.si.activities.server.domain.Subject;
import com.si.activities.server.dtos.ActivityRequest;
import com.si.activities.server.dtos.ActivityResponse;
import com.si.activities.server.repositories.ActivityRepository;
import com.si.activities.server.repositories.SubjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityService {
  private final ActivityRepository repo;
  private final SubjectRepository subjectRepo;
  private final ActivityMapper activityMapper;

  public ActivityResponse getById(Integer id) {
    Activity activity = repo.getReferenceById(id);

    return activityMapper.toDTO(activity);
  }

  public List<ActivityResponse> getAll() {
    return repo.findAll().stream().map(activityMapper::toDTO).toList();
  }

  public Integer create(ActivityRequest newActivity) {
    return repo.save(activityMapper.toEntity(newActivity)).getId();
  }
}
