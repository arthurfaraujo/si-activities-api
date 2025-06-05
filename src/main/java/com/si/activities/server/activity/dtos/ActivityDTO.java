package com.si.activities.server.activity.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public record ActivityDTO(
    Integer id,
    String name,
    String description,
    Integer classId,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo") Date startDate,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo") Date endDate,
    boolean isActive) {

}