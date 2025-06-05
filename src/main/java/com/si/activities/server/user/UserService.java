package com.si.activities.server.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.si.activities.server.role.RoleRepository;
import com.si.activities.server.classes.ClassService;
import com.si.activities.server.user.dtos.UserCreateDTO;
import com.si.activities.server.user.dtos.UserDTO;
import com.si.activities.server.user.dtos.UserMapper;

import jakarta.persistence.EntityNotFoundException;

import com.si.activities.server.role.Role;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

  private final UserRepository repo;
  private final RoleRepository roleRepo;
  private final ClassService classService;
  private final UserMapper mapper;

  public UserDTO getById(Integer id) {
    return mapper.toDTO(repo.findById(id).orElseThrow(() -> {
      return new EntityNotFoundException("Class not found with id: " + id);
    }));
  }
  
  public User getEntityById(Integer id) {
    return repo.getReferenceById(id);
  }

  public UserDTO create(UserCreateDTO newUser) {
    if (repo.findByNickname(newUser.nickname()) != null || repo.findByEmail(newUser.email()) != null) {
      return null;
    }

    Set<Role> roles = new HashSet<Role>();
    roles.add(roleRepo.findRoleByDescription("user"));

    String criptPass = new BCryptPasswordEncoder().encode(newUser.password());

    User user = repo.save(new User(newUser.name(), newUser.nickname(), newUser.email(), criptPass, roles));

    return new UserDTO(user.getId(), user.getName(), user.getNickname(), user.getRoles());
  }

  public List<UserDTO> getUsersByClass(Integer courseId) {
    classService.getById(courseId);

    return repo.findAllByCourseId(courseId).stream().map(mapper::toDTO).toList();
  }

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = repo.findByNickname(username);

    // initialize by hand the roles property
    user.getRoles().size();
    return user;
  }
}
