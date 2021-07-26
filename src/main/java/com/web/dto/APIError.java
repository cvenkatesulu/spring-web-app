package com.web.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class APIError {

    private HttpStatus status;
    private List<String> error;
    private LocalDateTime timeStamp;
    private String pathURI;

}
