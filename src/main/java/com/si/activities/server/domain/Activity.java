package com.si.activities.server.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class Activity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String name;

  @Column
  private String description;

  @Column(nullable = false)
  private String subject;

  @Column
  private Date startDate;

  @Column
  private Date endDate;

  @Transient
  public boolean getIsActive() {
    Date currentDate = new Date();

    return (endDate != null && currentDate.before(endDate));
  }
}
