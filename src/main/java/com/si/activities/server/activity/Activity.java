package com.si.activities.server.activity;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

  @Column(columnDefinition = "DATE")
  private Date startDate;

  @Column(columnDefinition = "DATE")
  private Date endDate;
  
  @JsonManagedReference
  @ManyToOne
  @JoinColumn(name = "class_id", nullable = false)
  @JsonProperty("class")
  private com.si.activities.server.classes.Class schoolClass;

  @Transient
  public boolean getIsActive() {
    Date currentDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());

    return (endDate != null && currentDate.compareTo(endDate) <= 0);
  }
}
