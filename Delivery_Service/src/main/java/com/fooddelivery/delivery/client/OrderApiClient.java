package com.fooddelivery.delivery.client;

public interface OrderApiClient
{
    void updateOrderStatus(long orderId, String orderStatus);
}
