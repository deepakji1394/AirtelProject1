package com.airtel.orderservice.controllers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class PlaceOrderRequest {

    @JsonProperty("item_id")
    private Long itemId;

    @JsonProperty("quantity")
    private Integer quantity;
}
