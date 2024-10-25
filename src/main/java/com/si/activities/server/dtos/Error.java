package com.si.activities.server.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Error(List<String> errors, String error, int status) {
	public Error(List<String> errors, int status) {
    this(errors, null, status);
  }

  public Error(String error, int status) {
    this(null, error, status);
  }
}
