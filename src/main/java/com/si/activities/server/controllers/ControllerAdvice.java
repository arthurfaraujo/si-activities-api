package com.si.activities.server.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ResponseStatusException;

import com.si.activities.server.dtos.ErrorDTO;

@RestControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler({MethodArgumentNotValidException.class, MethodArgumentTypeMismatchException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorDTO handleArgumentNotValidException(Exception e) {
    List<String> errors = new ArrayList<>();

    if (e instanceof MethodArgumentNotValidException) {
      MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
      for (FieldError error : ex.getFieldErrors()) {
        StringBuilder errorMessage = new StringBuilder();
        errorMessage.append(error.getField() + " ").append(error.getDefaultMessage());
        errors.add(errorMessage.toString());
      }
  
    } else if (e instanceof MethodArgumentTypeMismatchException) {
      MethodArgumentTypeMismatchException ex = (MethodArgumentTypeMismatchException) e;
      errors.add(ex.getName() + " " + "type mismatch");
    }
    return new ErrorDTO(errors, HttpStatus.BAD_REQUEST.value());
  }
  
  @ExceptionHandler(ResponseStatusException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<ErrorDTO> handleResponseStatusException(ResponseStatusException e) {
    return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getReason(), e.getStatusCode().value()), e.getStatusCode());
  }
}
