package com.si.activities.server.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public record ActivityRequest(String name, String description, String subject,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo") Date startDate,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo") Date endDate) {

}
