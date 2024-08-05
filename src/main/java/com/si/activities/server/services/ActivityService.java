package com.si.activities.server.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.si.activities.server.domain.Activity;
import com.si.activities.server.dtos.ActivityRequest;
import com.si.activities.server.dtos.ActivityResponse;
import com.si.activities.server.repositories.ActivityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityService {
  private final ActivityRepository repo;

  public ActivityResponse getById(Integer id) {
    Activity activity = repo.getReferenceById(id);

    return new ActivityResponse(
        id,
        activity.getName(),
        activity.getDescription(),
        activity.getSubject(),
        activity.getStartDate(),
        activity.getEndDate(),
        activity.getIsActive());
  }

  public List<ActivityResponse> getAll() {
    return repo.findAll().stream().map(activity -> new ActivityResponse(
        activity.getId(),
        activity.getName(),
        activity.getDescription(),
        activity.getSubject(),
        activity.getStartDate(),
        activity.getEndDate(),
        activity.getIsActive())).toList();
  }

  public Integer create(ActivityRequest newActivity) {
    Activity activity = new Activity();
    activity.setName(newActivity.name());
    activity.setDescription(newActivity.description());
    activity.setSubject(newActivity.subject());
    activity.setStartDate(newActivity.startDate());
    activity.setEndDate(newActivity.endDate());

    repo.save(activity);

    return activity.getId();
  }
}
