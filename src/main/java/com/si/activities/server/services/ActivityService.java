package com.si.activities.server.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.si.activities.server.dtos.activity.ActivityMapper;
import com.si.activities.server.dtos.activity.ActivityCreateDTO;
import com.si.activities.server.dtos.activity.ActivityDTO;
import com.si.activities.server.repositories.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ActivityService {
  private final ActivityRepository repo;
  private final ActivityMapper activityMapper;

  public ActivityDTO getById(Integer id) {
    return repo.findById(id).map(activityMapper::toDTO).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found"));
  }

  public List<ActivityDTO> getAll() {
    return repo.findAll().stream().map(activityMapper::toDTO).toList();
  }

  public Integer create(ActivityCreateDTO newActivity) {
    return repo.save(activityMapper.toEntity(newActivity)).getId();
  }
}
