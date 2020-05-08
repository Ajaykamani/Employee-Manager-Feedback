package com.cts.employeeService.exceptions.globalExceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponseType> customHandleValidationException(ValidationException ex, WebRequest request) {
    	log.error("validation exception : {}",ex);
        ErrorResponseType errorResponse = ErrorResponseType.builder().errMsg(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now()).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseType> customHandleNotFound(Exception ex, WebRequest request) {
    	log.error("Resource not found exception : {}",ex);
        ErrorResponseType errorResponse = ErrorResponseType.builder().errMsg(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timestamp(LocalDateTime.now()).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // This method will take care of other exceptions than what is already handled
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseType> customHandleException(Exception ex, WebRequest request) {
    	log.error("Exception : {}",ex);
        ErrorResponseType errorResponse = ErrorResponseType.builder().errMsg("Something went wrong!").errDetail(ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp(LocalDateTime.now()).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}