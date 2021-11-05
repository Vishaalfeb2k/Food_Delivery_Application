package com.fooddelivery.payment.service;

import java.util.List;

import com.fooddelivery.payment.dto.NetBanking;
import org.springframework.http.ResponseEntity;

public interface NetBankingService {

	void enterupiaddress(NetBanking netBanking);

	List<NetBanking> showupidetail() throws Exception;

    void removeaccount(Long id);

    void updateOrderStatus(long orderId, String orderStatus);

    ResponseEntity<NetBanking> updatePaymentStatusById(long id, String paymentStatus);
}
