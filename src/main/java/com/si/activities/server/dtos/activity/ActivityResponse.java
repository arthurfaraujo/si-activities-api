package com.si.activities.server.dtos.activity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public record ActivityResponse(
    Integer id,
    String name,
    String description,
    Integer subjectId,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo") Date startDate,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo") Date endDate,
    boolean isActive) {

}