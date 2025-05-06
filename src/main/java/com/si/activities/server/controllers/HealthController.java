package com.si.activities.server.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/health")
public class HealthController {

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public void get() {
    return;
  }
}
