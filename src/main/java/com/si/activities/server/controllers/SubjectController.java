package com.si.activities.server.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.si.activities.server.dtos.SubjectDTO;
import com.si.activities.server.services.SubjectService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/subjects")
@RequiredArgsConstructor
public class SubjectController {

  private final SubjectService service;

  @GetMapping("/{id}")
  public SubjectDTO getById(@PathVariable Integer id) {
    return service.getById(id);
  }

  @GetMapping
  public List<SubjectDTO> getAll() {
    return service.getAll();
  }
  
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public Integer create(@RequestBody SubjectDTO subject) {
    return service.create(subject);
  }
}
