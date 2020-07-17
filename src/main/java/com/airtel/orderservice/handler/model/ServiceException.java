package com.airtel.orderservice.handler.model;

/**
 * Exception class to map errors from service layer
 *
 * @author dmalhotra
 * @version 1.0.0
 */
public class ServiceException extends ApiException {

    /**
     * Constructs a new thor exception with the specified code and detail message.
     *
     * @param code    the specified error code
     * @param message the detail message
     * @since 1.0.0
     */
    public ServiceException(String code, String message) {
        this(code, message, null);
    }

    /**
     * Constructs a new thor exception with the specified code, detail message and
     * cause.
     *
     * @param code    the specified error code
     * @param message the detail message
     * @param cause   the cause (which is saved for later retrieval by the
     *                {@link #getCause()} method).  (A <tt>null</tt> value is
     *                permitted, and indicates that the cause is nonexistent or
     *                unknown.)
     * @since 1.0.0
     */
    public ServiceException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
