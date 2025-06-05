package com.si.activities.server.enrollment;

import java.util.Date;

import com.si.activities.server.classes.Class;
import com.si.activities.server.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "user_class")
@Table(name = "user_class")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Enrollment {
  
  @EmbeddedId
  private EnrollmentId id = new EnrollmentId();

  @ManyToOne
  @MapsId("userId")
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @MapsId("classId")
  @JoinColumn(name = "class_id")
  private Class class1;

  @Column
  private Date enrollmentDate;
}
