package com.example.demo.controller.exception_handler;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.util.ErrorTitleUtil.BAD_REQUEST;
import static com.example.demo.util.LogFormatUtil.ERROR_FOR_LOG;
import static com.example.demo.util.LogFormatUtil.HANDLER_ERROR_DEBUG_FORMAT;
import static com.example.demo.util.LogFormatUtil.HANDLER_ERROR_INFO_FORMAT;
import static java.lang.String.format;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    protected void logError(@NonNull Throwable e) {
        if (!log.isErrorEnabled()) {
            return;
        }
        log.error(HANDLER_ERROR_INFO_FORMAT, ERROR_FOR_LOG, e.getClass().getSimpleName(), e.getMessage());
        if (log.isDebugEnabled()) {
            log.error(format(HANDLER_ERROR_DEBUG_FORMAT, ERROR_FOR_LOG, e.getClass().getSimpleName(), e.getMessage(), e));
        }
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorObject> handleEntityNotFoundException(EntityNotFoundException ex) {
        var errorObject = new ErrorObject(BAD_REQUEST, ex.getMessage());
        logError(ex);
        return new ResponseEntity<>(errorObject, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorObject> handleBadRequestException(BadRequestException ex) {
        var errorObject = new ErrorObject(BAD_REQUEST, ex.getMessage());
        logError(ex);
        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {IllegalStateException.class, IllegalArgumentException.class})
    public ResponseEntity<ErrorObject> handleIllegalStateArgumentException(Exception ex) {
        var errorObject = new ErrorObject(BAD_REQUEST, ex.getMessage());
        logError(ex);
        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorObject> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception, WebRequest request) {
        List<String> errors = new ArrayList<>();
        exception.getBindingResult().getAllErrors().forEach(error -> {
            if (error instanceof FieldError fieldError) {
                String fieldName = fieldError.getField();
                String errorMessage = fieldError.getDefaultMessage();
                errors.add(format("%s: %s", fieldName, errorMessage));
            } else {
                errors.add(format("%s: %s", error.getObjectName(), error.getDefaultMessage()));
            }
        });
        var errorResponse = new ErrorObject(BAD_REQUEST, errors);
        logError(exception);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorObject> handleIllegalStateArgumentException(NullPointerException ex) {
        var errorObject = new ErrorObject(BAD_REQUEST, ex.getMessage());
        logError(ex);
        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
    }
}
