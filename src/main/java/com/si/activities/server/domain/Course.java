package com.si.activities.server.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank
  @Column
  private String name;

  @ManyToMany(cascade = {
      CascadeType.PERSIST,
      CascadeType.MERGE
  })
  @JoinTable(name = "course_period",
      joinColumns = @JoinColumn(name = "course_id"),
      inverseJoinColumns = @JoinColumn(name = "period_id"))
  private Set<Period> periods = new HashSet<>();

  public void addPeriod(Period per) {
    periods.add(per);
    per.getCourses().add(this);
  }

  public void removePeriod(Period per) {
    periods.remove(per);
    per.getCourses().remove(this);
  }
}
