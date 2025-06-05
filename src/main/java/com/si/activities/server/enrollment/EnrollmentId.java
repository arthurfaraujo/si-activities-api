package com.si.activities.server.enrollment;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class EnrollmentId implements Serializable {
  private Integer userId;
  private Integer classId;

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;

    if (!(o instanceof EnrollmentId))
      return false;

    EnrollmentId obj = (EnrollmentId) o;

    return Objects.equals(obj.getUserId(), userId) && Objects.equals(obj.getClassId(), classId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, classId);
  }
}
