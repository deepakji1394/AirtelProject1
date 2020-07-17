package com.airtel.orderservice.controllers;

import com.airtel.orderservice.controllers.model.*;
import com.airtel.orderservice.handler.model.BadRequestException;
import com.airtel.orderservice.handler.model.ErrorCode;
import com.airtel.orderservice.handler.model.NotFoundException;
import com.airtel.orderservice.handler.model.ServiceException;
import com.airtel.orderservice.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Rest controller for order service
 *
 * @author dmalhotra
 * @version 1.0.0
 */
@RestController
@RequestMapping("/")
public class OrderController {

    /**
     * private static class level logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    /**
     * order service obj
     */
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/api/v1/order", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> placeOrder(@RequestBody PlaceOrderRequest request) throws Exception {
        PlacedOrderResponse placedOrderResponse = null;
        try {
            //TODO all basic validation before calling service and throw IllegalArgumentException if fails
        } catch (IllegalArgumentException ex) {
            // any illegal argument exception here means that client request is invalid and
            // must return 400
            throw new BadRequestException(ErrorCode.BAD_REQUEST, ex.getMessage(), ex);
        }
        placedOrderResponse = orderService.placeOrder(request);
        return ResponseEntity.ok(placedOrderResponse);
    }

    @GetMapping(value = "/api/v1/order/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getOrderDetail(@PathVariable("orderId") Long orderId) throws NotFoundException, BadRequestException, ServiceException {
        try {
            //TODO all basic validation before calling service and throw IllegalArgumentException if fails
        } catch (IllegalArgumentException ex) {
            // any illegal argument exception here means that client request is invalid and
            // must return 400
            throw new BadRequestException(ErrorCode.BAD_REQUEST, ex.getMessage(), ex);
        }
        OrderDetailResponse response = orderService.getOrderDetail(orderId);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/api/v1/order", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateOrder(@RequestBody UpdateOrderRequest request) throws NotFoundException, BadRequestException, ServiceException {
        OrderDetailResponse response = null;
        try {
            //TODO all basic validation before calling service and throw IllegalArgumentException if fails
        } catch (IllegalArgumentException ex) {
            // any illegal argument exception here means that client request is invalid and
            // must return 400
            throw new BadRequestException(ErrorCode.BAD_REQUEST, ex.getMessage(), ex);
        }
        response = orderService.updateOrderStatus(request);
        return ResponseEntity.ok(response);
    }

}
