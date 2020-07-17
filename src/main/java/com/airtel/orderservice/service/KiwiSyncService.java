package com.airtel.orderservice.service;

/**
 * Service class which offers functionality to push data onto kafka
 *
 * @author dmalhotra
 * @version 2.0.0
 */
public interface KiwiSyncService {

    /**
     * service to push to kafka
     *
     * @param method api method
     * @param apiPath api path
     * @param payload request payload
     * @throws Exception if any error occur
     */
    void pushToKafkaJobApplyEvent(String method, String apiPath, Object payload)
            throws Exception;

}
