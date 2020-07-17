package com.airtel.orderservice.handler.model;


import java.util.Map;

/**
 * Exception thrown when rate limit exceeds the threshold
 *
 * @author dmalhotra
 * @version 1.0.0
 */
public class ClientAccessDeniedException extends ApiException {

    /**
     * Constructs a rate limit exception with specified additional info
     *
     * @param info the additional info
     */
    public ClientAccessDeniedException(Map<String, Object> info) {
        this(ErrorCode.CLIENT_ACCESS_DENIED, "This client is not authorized to access the api's", info);
    }

    /**
     * Constructs a rate limit exception with specified message, code and additional info
     *
     * @param code    the error code
     * @param message the specified message
     * @param info    the additional info
     */
    public ClientAccessDeniedException(String code, String message, Map<String, Object> info) {
        super(code, message, null, info);
    }
}
