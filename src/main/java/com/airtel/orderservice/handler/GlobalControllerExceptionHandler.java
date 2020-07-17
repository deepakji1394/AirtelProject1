package com.airtel.orderservice.handler;

import com.airtel.orderservice.handler.model.*;
import com.airtel.orderservice.properties.OrderServiceProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Global controller level exception handler
 *
 * @author dmalhotra
 * @version 1.0.0
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    /**
     * Private static class level logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

    /**
     * Application properties resolved by spring
     */
    @Autowired
    private OrderServiceProperties properties;

    /**
     * Handle any other exceptional cases
     *
     * @param th the cause
     * @return the error response
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleThrowable(Exception th) {
        LOGGER.error("unknown server exception", th);
        String message = th.getMessage();
        ErrorResponse response = new ErrorResponse();
        response.setErrorCode(ErrorCode.SERVER_ERROR);
        response.setErrorMessage(message);
        response.setAppName(properties.getAppName());
        response.setAppVersion(properties.getAppVersion());
        if (th.getCause() != null) {
            final Map<String, Object> info = new HashMap<String, Object>();
            info.put("causeErrorClass", th.getCause().getClass().getCanonicalName());
            info.put("causeErrorMessage", th.getCause().getMessage());
            info.put("causeStackTrace", th.getCause().getStackTrace());
            response.setInfo(info);
        }
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handle {@link BadRequestException}
     *
     * @param bre the cause
     * @return the error response
     */
    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException bre) {
        LOGGER.error("bad request exception", bre);
        String message = bre.getMessage();
        ErrorResponse response = new ErrorResponse();
        response.setErrorMessage(message);
        response.setErrorCode(bre.getCode());
        response.setAppName(properties.getAppName());
        response.setAppVersion(properties.getAppVersion());
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle {@link ServiceException}
     *
     * @param te the cause
     * @return the error response
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleApiException(ServiceException te) {
        LOGGER.error("unknown service exception", te);
        String message = te.getMessage();
        ErrorResponse response = new ErrorResponse();
        response.setErrorCode(te.getCode());
        response.setErrorMessage(message);
        response.setAppName(properties.getAppName());
        response.setAppVersion(properties.getAppVersion());

        return new ResponseEntity<ErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handle {@link NotFoundException}
     *
     * @param nfe the cause
     * @return the error response
     */
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException nfe) {
        LOGGER.error("resource not found exception", nfe);
        String message = nfe.getMessage();
        ErrorResponse response = new ErrorResponse();
        response.setErrorCode(nfe.getCode());
        response.setErrorMessage(message);
        response.setAppName(properties.getAppName());
        response.setAppVersion(properties.getAppVersion());
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
    }
}
