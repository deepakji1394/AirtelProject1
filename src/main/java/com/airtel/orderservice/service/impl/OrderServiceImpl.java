package com.airtel.orderservice.service.impl;

import com.airtel.orderservice.controllers.model.OrderDetailResponse;
import com.airtel.orderservice.controllers.model.PlaceOrderRequest;
import com.airtel.orderservice.controllers.model.PlacedOrderResponse;
import com.airtel.orderservice.controllers.model.UpdateOrderRequest;
import com.airtel.orderservice.entities.Order;
import com.airtel.orderservice.handler.model.BadRequestException;
import com.airtel.orderservice.handler.model.ErrorCode;
import com.airtel.orderservice.handler.model.NotFoundException;
import com.airtel.orderservice.handler.model.ServiceException;
import com.airtel.orderservice.model.OrderStatus;
import com.airtel.orderservice.model.PlacedOrderSync;
import com.airtel.orderservice.repositories.OrderRepository;
import com.airtel.orderservice.service.KiwiSyncService;
import com.airtel.orderservice.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    /**
     * private static class level logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private KiwiSyncService kiwiSyncService;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public PlacedOrderResponse placeOrder(PlaceOrderRequest request) throws Exception {
        Order order = new Order();
        order.setItemId(request.getItemId());
        order.setQuantity(request.getQuantity());
        order.setStatus(OrderStatus.PLACED);
        int r = (int) (Math.random() * (30 - 20)) + 20;
        order.setDeliveryTime(r);
        order = orderRepository.save(order);


        kiwiSyncService.pushToKafkaJobApplyEvent(HttpMethod.POST.name(), "/api/v1/order", new PlacedOrderSync(order.getId()));
        return new PlacedOrderResponse(order.getId(), order.getStatus().toString(), order.getDeliveryTime(), null);
    }

    @Override
    public OrderDetailResponse getOrderDetail(Long orderId) throws NotFoundException, BadRequestException, ServiceException {

        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if(!orderOptional.isPresent()){
            throw new NotFoundException(ErrorCode.RESOURCE_NOT_FOUND, "order not found");
        }
        Order order = orderOptional.get();
        return new OrderDetailResponse(order.getStatus().toString());
    }

    @Override
    @Transactional
    public OrderDetailResponse updateOrderStatus(UpdateOrderRequest request) throws NotFoundException, BadRequestException, ServiceException {
        Optional<Order> orderOptional = orderRepository.findById(request.getOrderId());
        if(!orderOptional.isPresent()){
            throw new NotFoundException(ErrorCode.RESOURCE_NOT_FOUND, "order not found");
        }
        Order order = orderOptional.get();
        order.setStatus(OrderStatus.valueOf(request.getStatus()));
        order = orderRepository.save(order);
        return new OrderDetailResponse(order.getStatus().toString());
    }
}
