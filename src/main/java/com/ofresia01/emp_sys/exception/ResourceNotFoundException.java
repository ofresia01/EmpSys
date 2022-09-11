/*
    Java exception class extending RuntimeException that defines ResourceNotFound exception for a NOT_FOUND response status from HttpStatus
 */
package com.ofresia01.emp_sys.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // Annotation defining response code for class to respond to
public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    // Exception method definition with format specifiers for defined attributes
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue)); // Super used to resolve ambiguity with attribute names
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}