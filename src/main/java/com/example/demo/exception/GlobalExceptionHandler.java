package com.example.demo.exception;

import com.example.demo.dto.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // ===== CUSTOM RUNTIME ERROR =====
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<Object> handleRuntimeException(RuntimeException ex) {
        log.error("Lỗi xảy ra: ", ex);
        return ApiResponse.error(500,null, ex.getMessage());
    }

    // ===== CATCH ALL =====
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<Object> handleException(Exception e) {
        log.error("Lỗi hệ thống xảy ra: ", e);
        return ApiResponse.error(500, null,"Chịu chết" + e.getMessage());
    }
}