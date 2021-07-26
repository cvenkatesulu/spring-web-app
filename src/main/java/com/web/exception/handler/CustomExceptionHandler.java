package com.web.exception.handler;

import com.web.dto.APIError;
import com.web.exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<?> userNotFoundHandler(Exception ex, ServletWebRequest servletWebRequest) {

        APIError apiError = new APIError();
        apiError.setTimeStamp(LocalDateTime.now());
        apiError.setStatus(HttpStatus.BAD_REQUEST);
        apiError.setError(Arrays.asList(ex.getMessage()));
        apiError.setPathURI(servletWebRequest.getDescription(true));

        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<String> errors = fieldErrors.stream().map(err -> err.getField() + ":" + err.getDefaultMessage()).collect(Collectors.toList());

        APIError apiError = new APIError();
        apiError.setError(errors);
        apiError.setTimeStamp(LocalDateTime.now());
        apiError.setStatus(HttpStatus.BAD_REQUEST);
        apiError.setPathURI(request.getDescription(false));

        return new ResponseEntity<>(apiError, headers, apiError.getStatus());
    }
}
