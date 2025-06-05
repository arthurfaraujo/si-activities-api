package com.si.activities.server.activity;

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

import com.si.activities.server.activity.dtos.ActivityCreateDTO;
import com.si.activities.server.activity.dtos.ActivityDTO;

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
  public ActivityDTO getById(@PathVariable @NotNull Integer id) {
    
    return service.getById(id);
  }

  @GetMapping
  public List<ActivityDTO> getAll() {
    return service.getAll();
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public Integer create(@RequestBody @Valid ActivityCreateDTO activity) {
    return service.create(activity);
  }
}
