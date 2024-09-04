package com.si.activities.server.domain;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Activity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank
  @Column(nullable = false)
  private String name;

  @Column
  private String description;

  @NotBlank
  @Column(nullable = false)
  private String subject;

  @Column
  private Date startDate;

  @Column
  private Date endDate;

  @Transient
  public boolean getIsActive() {
    Date currentDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());

    return (endDate != null && currentDate.compareTo(endDate) <= 0);
  }
}
