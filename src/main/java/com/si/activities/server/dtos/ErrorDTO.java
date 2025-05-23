package com.si.activities.server.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorDTO(List<String> errors, String error, int status) {
	public ErrorDTO(List<String> errors, int status) {
    this(errors, null, status);
  }

  public ErrorDTO(String error, int status) {
    this(null, error, status);
  }
}
