package com.airtel.orderservice.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Base class to hold all the application specific properties
 *
 * @author dmalhotra
 * @version 1.0.0
 */
@Component
@ConfigurationProperties("orderService")
@Validated
@Getter
@Setter
public class OrderServiceProperties {

    /**
     * The app name
     */
    @NotEmpty
    private String appName;

    /**
     * The app version
     */
    @NotEmpty
    private String appVersion;

    /**
     * Generic error message for the server
     */
    @NotEmpty
    private String genericErrorMessage;

    /**
     * The kafka properties
     */
    @Valid
    @NotNull
    private KafkaProperties kafkaProperties;

    @NotEmpty
    private String orderTopic;
}
