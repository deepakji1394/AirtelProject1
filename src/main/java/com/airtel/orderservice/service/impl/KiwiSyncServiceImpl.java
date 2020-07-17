package com.airtel.orderservice.service.impl;

import com.airtel.orderservice.properties.OrderServiceProperties;
import com.airtel.orderservice.service.KiwiSyncService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Implementation of {@link KiwiSyncService}
 *
 * @author garima
 * @version 1.0.0
 */
@Service
public class KiwiSyncServiceImpl implements KiwiSyncService {

    /**
     * private static class level logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(KiwiSyncServiceImpl.class);

    /**
     * The object mapper resolved by spring
     */
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * The kafka producer bean
     */
    @Autowired
    private KafkaProducer<String, String> kafkaProducer;

    @Autowired
    private OrderServiceProperties properties;

    /**
     * service to push to kafka
     *
     * @param method  api method
     * @param apiPath api path
     * @param payload request payload
     * @throws Exception if any error occur
     */
    @Override
    public void pushToKafkaJobApplyEvent(String method, String apiPath, Object payload) throws Exception {
        String json = objectMapper.writeValueAsString(payload);

        ProducerRecord<String, String> record = new ProducerRecord<String, String>(properties.getOrderTopic(), json);
        LOGGER.debug(String.format("Sending event to kafka, event data \n[%s]", json));

        try{
            RecordMetadata metadata = kafkaProducer.send(record).get();
            LOGGER.debug(String.format("message sent successfully to kafka, topic [%s] record offset [%s]", properties.getOrderTopic(),
                    metadata.offset()));
        }catch(Exception e){
            LOGGER.error("Un-able to push data into kafaka, Saving into mongo",e);
            //if fail can save those events
        }
    }
}
