package com.airtel.orderservice.model;

public enum OrderStatus {
        PLACED,
        IN_PROGRESS,
        OUT_FOR_DELIVERY,
        DELIVERED;

    private OrderStatus() {
    }
}
