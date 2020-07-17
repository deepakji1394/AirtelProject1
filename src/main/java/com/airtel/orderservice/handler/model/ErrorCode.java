package com.airtel.orderservice.handler.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ErrorCode {

    public static final String BAD_REQUEST = "BAD_REQUEST";
    public static final String UNKNOWN = "UNKNOWN";
    public static final String NON_OK_STATUS_CODE = "NON_OK_STATUS_CODE";
    public static final String EXTERNAL_SERVICE_ERROR = "EXTERNAL_SERVICE_ERROR";
    public static final String EXTERNAL_SERVICE_INVALID_ERROR_CODE = "EXTERNAL_SERVICE_INVALID_ERROR_CODE";
    public static final String EXTERNAL_SERVICE_INVALID_ERROR_RESPONSE = "EXTERNAL_SERVICE_INVALID_ERROR_RESPONSE";
    public static final String RESOURCE_NOT_FOUND = "RESOURCE_NOT_FOUND";
    public static final String CREDENTIAL_DECODING_FAILED = "CREDENTIAL_DECODING_FAILED";
    public static final String CREDENTIAL_ENCODING_FAILED = "CREDENTIAL_ENCODING_FAILED";
    public static final String ACCESS_TOKEN_VALIDATION_FAILED = "ACCESS_TOKEN_VALIDATION_FAILED";
    public static final String ACCESS_TOKEN_EXPIRED = "ACCESS_TOKEN_EXPIRED";
    public static final String ACCESS_TOKEN_PERMISSION_DENIED = "ACCESS_TOKEN_PERMISSION_DENIED";
    public static final String CLIENT_ACCESS_DENIED = "CLIENT_ACCESS_DENIED";
    public static final String ACCESS_DENIED = "ACCESS_DENIED";
    public static final String INVALID_IP_ADDRESS = "INVALID_IP_ADDRESS";
    public static final String TOKEN_VALIDATION_FAILED = "TOKEN_VALIDATION_FAILED";
    public static final String EMPTY_AUTH_HEADER = "EMPTY_AUTH_HEADER";
    public static final String INVALID_AUTH_HEADER_TYPE = "INVALID_AUTH_HEADER_TYPE";
    public static final String AUTH_HEADER_SIGNATURE_VALIDATION_FAILED = "AUTH_HEADER_SIGNATURE_VALIDATION_FAILED";
    public static final String TOKEN_EXPIRED = "TOKEN_EXPIRED";
    public static final String INVALID_AUTH_HEADER = "INVALID_AUTH_HEADER";
    public static final String INVALID_TOKEN_ACL = "INVALID_TOKEN_ACL";
    public static final String INVALID_OTP = "INVALID_OTP";
    public static final String EMAIL_NOT_FOUND = "EMAIL_NOT_FOUND";
    public static final String EMAIL_NOT_VERIFIED = "EMAIL_NOT_VERIFIED";
    public static final String EMAIL_EXISTS = "EMAIL_EXISTS";
    public static final String MOBILE_NUMBER_EXISTS = "MOBILE_NUMBER_EXISTS";
    public static final String MOBILE_NUMBER_NOT_FOUND = "MOBILE_NUMBER_NOT_FOUND";
    public static final String MOBILE_NUMBER_NOT_VERIFIED = "MOBILE_NUMBER_NOT_VERIFIED";
    public static final String USER_ACCESS_TOKEN_MISSING = "USER_ACCESS_TOKEN_MISSING";
    public static final String USER_ACCESS_TOKEN_INVALID_SIGNATURE = "USER_ACCESS_TOKEN_INVALID_SIGNATURE";
    public static final String USER_ACCESS_TOKEN_EXPIRED = "USER_ACCESS_TOKEN_EXPIRED";
    public static final String NOTIFICATION_SERVICE_ERROR = "NOTIFICATION_SERVICE_ERROR";
    public static final String INVALID_AUTHENTICATION = "INVALID_AUTHENTICATION";
    public static final String API_NOT_IN_USE = "API_NOT_IN_USE";
    public static final String SERVER_ERROR = "SERVER_ERROR";
}
