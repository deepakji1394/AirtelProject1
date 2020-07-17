package com.airtel.orderservice.controllers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateOrderRequest {

    @JsonProperty("order_id")
    private Long orderId;

    private String status;

}
