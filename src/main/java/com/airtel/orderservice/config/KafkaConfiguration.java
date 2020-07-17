package com.airtel.orderservice.config;

import com.airtel.orderservice.properties.OrderServiceProperties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The kafka configuration
 *
 * @author dmalhotra
 * @version 1.0.0
 */
@Configuration
public class KafkaConfiguration {

    /**
     * private static class level logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConfiguration.class);

    @Autowired
    private OrderServiceProperties properties;


    /**
     * Creates bean of kafka producer {@link KafkaProducer} object.
     *
     * @return KafkaProducer the kafka producer bean
     */
    @Bean
    public KafkaProducer<String, String> getProducer(OrderServiceProperties properties) {
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(
                properties.getKafkaProperties().getProducerProperties());

        Thread shutdownHook = new ShutdownHook(producer);

        Runtime.getRuntime().addShutdownHook(shutdownHook);

        return producer;
    }


    /**
     * Producer shutdown hook
     */
    private static class ShutdownHook extends Thread {

        /**
         * The producer
         */
        private final KafkaProducer<String, String> producer;

        /**
         * Create an instance of shutdown hook with specified producer
         *
         * @param producer the kafka producer
         */
        public ShutdownHook(KafkaProducer<String, String> producer) {
            if (producer == null) {
                throw new IllegalArgumentException("null producer specified, producer must not be null");
            }
            this.producer = producer;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void run() {
            LOGGER.info("shutting down application, closing kafka producer");
            producer.close();
            LOGGER.info("kafka producer shutdown successfully");
        }
    }
    
}
