package com.si.activities.server.classes.dtos;

import com.si.activities.server.subject.dtos.SubjectDTO;

public record ClassDTO(Integer id, String referencePeriod, SubjectDTO subject) {}
