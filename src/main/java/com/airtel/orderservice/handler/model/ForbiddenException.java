package com.airtel.orderservice.handler.model;

/**
 * Exception thrown when user is not authorized to access the specified resource
 *
 * @author dmalhotra
 * @version 1.0.0
 */
public class ForbiddenException extends ApiException {

    /**
     * Create an instance of new forbidden exception with specified code, message and cause
     *
     * @param code    the specified code
     * @param message the specified message
     * @param cause   the specified cause
     */
    public ForbiddenException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
