package com.airtel.orderservice.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * The kafka configuration properties
 *
 * @author dmalhotra
 * @version 1.0.0
 */
@Validated
@Getter
@Setter
public class KafkaProperties {

    /**
     * The producer properties
     */
    @NotNull
    private Map<String, Object> producerProperties;

}
