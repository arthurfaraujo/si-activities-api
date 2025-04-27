package com.si.activities.server.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.si.activities.server.dtos.user.UserDTO;
import com.si.activities.server.repositories.RoleRepository;
import com.si.activities.server.repositories.UserRepository;
import com.si.activities.server.domain.Role;
import com.si.activities.server.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

  private final UserRepository repo;
  private final RoleRepository roleRepo;

  public Optional<UserDTO> create(UserDTO newUser) {
    if (repo.findByNickname(newUser.nickname()) != null) {
      return null;
    }

    Set<Role> roles = new HashSet<Role>();
    roles.add(roleRepo.findRoleByDescription("user"));

    String criptPass = new BCryptPasswordEncoder().encode(newUser.password());

    User user = repo.save(new User(newUser.name(), newUser.nickname(), newUser.email(), criptPass, roles));

    return Optional
        .of(new UserDTO(user.getId(), user.getName(), user.getNickname(), user.getEmail(), user.getPassword()));
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return repo.findByNickname(username);
  }

}
