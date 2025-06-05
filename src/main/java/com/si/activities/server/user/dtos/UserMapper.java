package com.si.activities.server.user.dtos;

import org.springframework.stereotype.Component;

import com.si.activities.server.user.User;

@Component
public class UserMapper {
  
  public UserDTO toDTO(User user) {
    if (user == null) {
      return null;
    }

    return new UserDTO(user.getId(), user.getName(), user.getNickname(), user.getRoles());
  }
}
