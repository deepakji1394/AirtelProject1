package com.airtel.orderservice.handler.model;

import lombok.Data;

import java.util.Map;

@Data
public class ErrorResponse {

    private String appName;
    private String appVersion;
    private String errorCode;
    private String errorMessage;
    private Map<String, Object> info;
}
