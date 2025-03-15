package com.bootcamptoprod.spring_boot_swagger_request_response_validator_demo.exception;

import com.atlassian.oai.validator.springmvc.InvalidRequestException;
import com.atlassian.oai.validator.springmvc.InvalidResponseException;
import com.bootcamptoprod.spring_boot_swagger_request_response_validator_demo.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalErrorController extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalErrorController.class);

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<ErrorResponse> handleInvalidRequest(InvalidRequestException ex) {

        log.error("Request validation error: {}", ex.getValidationReport().getMessages());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("INVALID_REQUEST", ex.getValidationReport().getMessages()));
    }

    @ExceptionHandler(InvalidResponseException.class)
    public ResponseEntity<ErrorResponse> handleInvalidResponse(InvalidResponseException ex) {

        log.error("Response validation error: {}", ex.getValidationReport().getMessages());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("INVALID_RESPONSE", ex.getValidationReport().getMessages()));
    }
}
