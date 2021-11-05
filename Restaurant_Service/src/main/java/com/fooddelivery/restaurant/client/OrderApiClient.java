package com.fooddelivery.restaurant.client;

public interface OrderApiClient
{
    void updateOrderStatus(long orderId,String orderStatus);

}
