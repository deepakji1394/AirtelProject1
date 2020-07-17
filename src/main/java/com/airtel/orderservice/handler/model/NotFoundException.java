package com.airtel.orderservice.handler.model;

/**
 * Exception thrown in case the requested resource is not found on server
 *
 * @author dmalhotra
 * @version 1.0.0
 */
public class NotFoundException extends ApiException {

    /**
     * Create an instance of Not found exception with specified code and message
     *
     * @param code    the specified code
     * @param message the specified message
     */
    public NotFoundException(String code, String message) {
        super(code, message);
    }
}
