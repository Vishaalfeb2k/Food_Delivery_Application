package com.fooddelivery.payment.service;

import com.fooddelivery.payment.client.OrderApiClient;
import com.fooddelivery.payment.dto.NetBanking;
import com.fooddelivery.payment.exception.NoPaymentDetailException;
import com.fooddelivery.payment.repository.NetBankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NetBankingServiceImpl implements NetBankingService {

	@Autowired
	public NetBankingRepository nbRepo;

	@Autowired
	public OrderApiClient orderApiClient;
	
	public void enterupiaddress(NetBanking netBanking) {
		nbRepo.save(netBanking);

	}

	
	public List<NetBanking> showupidetail() throws Exception{
		
		List<NetBanking> nPayment = new ArrayList<>();
		 nbRepo.findAll().forEach(nPayment::add);
		if(nPayment.isEmpty()) {
			throw new NoPaymentDetailException("No details present");
		}
		 return nPayment;
	}

	@Override
	public void removeaccount(Long id) {
		nbRepo.deleteById(id);

	}

	@Override
	public void updateOrderStatus(long orderId, String orderStatus) {
		orderApiClient.updateOrderStatus(orderId,orderStatus);
	}

	@Override
	public ResponseEntity<NetBanking> updatePaymentStatusById(long id, String paymentStatus) {
		NetBanking netBanking=nbRepo.findById(id).get();
		Map<String,String> hm=new HashMap<>();
		hm.put("PENDING", "PAYMENT_SUCCESS");
		if(hm.get(netBanking.getPaymentStatus()).equals(paymentStatus))
		{
			netBanking.setPaymentStatus(paymentStatus);
			final NetBanking updatedStatus=nbRepo.save(netBanking);
			return ResponseEntity.ok(updatedStatus);
		}
		throw new NoPaymentDetailException("Invalid");
	}

}
