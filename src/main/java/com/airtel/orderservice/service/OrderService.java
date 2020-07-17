package com.airtel.orderservice.service;

import com.airtel.orderservice.controllers.model.OrderDetailResponse;
import com.airtel.orderservice.controllers.model.PlaceOrderRequest;
import com.airtel.orderservice.controllers.model.PlacedOrderResponse;
import com.airtel.orderservice.controllers.model.UpdateOrderRequest;
import com.airtel.orderservice.handler.model.BadRequestException;
import com.airtel.orderservice.handler.model.NotFoundException;
import com.airtel.orderservice.handler.model.ServiceException;

public interface OrderService {

    /**
     * place order
     *
     * @param request place order detail
     * @return order response
     * @throws NotFoundException if resource not found
     * @throws BadRequestException if any wrong parameter passed
     * @throws ServiceException if any other error occur
     */
    PlacedOrderResponse placeOrder(PlaceOrderRequest request) throws Exception;

    /**
     * get order detail
     *
     * @param orderId order id
     * @return order detail
     * @throws NotFoundException if resource not found
     * @throws BadRequestException if any wrong parameter passed
     * @throws ServiceException if any other error occur
     */
    OrderDetailResponse getOrderDetail(Long orderId) throws NotFoundException, BadRequestException, ServiceException;


    OrderDetailResponse updateOrderStatus(UpdateOrderRequest request) throws NotFoundException, BadRequestException, ServiceException;
}
