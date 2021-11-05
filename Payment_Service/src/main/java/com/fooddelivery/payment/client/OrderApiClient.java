package com.fooddelivery.payment.client;

public interface OrderApiClient
{
    void updateOrderStatus(long orderId,String orderStatus);

}
