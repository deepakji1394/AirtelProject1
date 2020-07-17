package com.airtel.orderservice.handler.model;

/**
 * Exception thrown when user don't have permission to access the specified resource
 *
 * @author dmalhotra
 * @version 1.0.0
 */
public class UnauthorizedException extends ApiException {

    /**
     * Create an instance of new unauthorized exception with specified code and message
     *
     * @param code    the specified code
     * @param message the specified message
     */
    public UnauthorizedException(String code, String message) {
        this(code, message, null);
    }

    /**
     * Create an instance of new unauthorized exception with specified code, message and cause
     *
     * @param code    the specified code
     * @param message the specified message
     * @param cause   the specified cause
     */
    public UnauthorizedException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
