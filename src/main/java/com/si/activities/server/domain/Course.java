package com.si.activities.server.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank
  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private Integer periodsNumber;

  @JsonBackReference
  @OneToMany(mappedBy = "course")
  private Set<User> users = new HashSet<User>();

  @JsonBackReference
  @OneToMany(mappedBy = "course")
  private Set<Subject> subjects = new HashSet<Subject>();
}
