package com.airtel.orderservice.controllers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlacedOrderResponse {

    @JsonProperty("order_id")
    private Long orderID;

    @JsonProperty("status")
    private String orderStatus;

    @JsonProperty("delivery_time")
    private Integer deliveryTime;

    @JsonProperty("extra_delivery_time")
    private Integer ExtraDeliveryTime;
}
