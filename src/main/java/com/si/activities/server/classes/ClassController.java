package com.si.activities.server.classes;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.si.activities.server.classes.dtos.ClassCreateDTO;
import com.si.activities.server.classes.dtos.ClassDTO;
import com.si.activities.server.user.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/classes")
@RequiredArgsConstructor
@Validated
public class ClassController {

  private final ClassService serv;

  @GetMapping
  public List<ClassDTO> getAllByUser(@AuthenticationPrincipal User user) {
    return serv.getAllByUserId(user.getId());
  }

  @PostMapping
  public ClassDTO create(@RequestBody ClassCreateDTO class1) {
    System.out.println(class1.subjectId());
    return serv.create(class1);
  }
}
