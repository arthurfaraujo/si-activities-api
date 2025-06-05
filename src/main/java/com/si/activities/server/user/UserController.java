package com.si.activities.server.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.si.activities.server.user.dtos.UserDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService service;
    
  @GetMapping("/class/{id}")
  public List<UserDTO> getUsersByClass(@PathVariable Integer id) {
    return service.getUsersByClass(id);
  }
}
