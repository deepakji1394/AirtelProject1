package com.airtel.orderservice.entities;

import com.airtel.orderservice.model.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * order table entity
 *
 * @author dmalhotra
 */
@Getter
@Setter
public class Order extends Deletable {


    @Column(name = "user_id", columnDefinition = "bigint", nullable = false)
    private Long userId;

    @Column(name = "item_id", columnDefinition = "bigint", nullable = false)
    private Long itemId;

    @Column(name = "user_id", columnDefinition = "int", nullable = false)
    private Integer quantity;

    //in minutes
    @Column(name = "delivery_time", columnDefinition = "int", nullable = false)
    private Integer deliveryTime;

    @Column(name = "delivery_man_id", columnDefinition = "bigint")
    private Long deliveryMan;

    @Column(name = "status", columnDefinition = "varchar(255)", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
