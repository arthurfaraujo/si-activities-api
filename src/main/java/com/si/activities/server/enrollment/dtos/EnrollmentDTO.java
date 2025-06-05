package com.si.activities.server.enrollment.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public record EnrollmentDTO(Integer userId, Integer classId,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo") Date enrollmentDate) {

}
