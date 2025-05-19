package com.si.activities.server.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.si.activities.server.dtos.activity.ActivityRequest;
import com.si.activities.server.dtos.activity.ActivityResponse;
import com.si.activities.server.services.ActivityService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
@Validated
public class ActivityController {

  private final ActivityService service;
  
  @GetMapping("/{id}")
  public ActivityResponse getById(@PathVariable @NotNull Integer id) {
    
    return service.getById(id);
  }

  @GetMapping
  public List<ActivityResponse> getAll() {
    return service.getAll();
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public Integer create(@RequestBody @Valid ActivityRequest activity) {
    return service.create(activity);
  }
}
