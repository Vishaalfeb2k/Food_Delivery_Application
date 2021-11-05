package com.fooddelivery.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fooddelivery.payment.dto.NetBanking;
import com.fooddelivery.payment.service.NetBankingService;

@RestController
public class PaymentController {

	@Autowired
	private NetBankingService nbService;

	@PutMapping("/OrderStatus/{orderId}")
	public void updateOrderStatus(@PathVariable long orderId, @RequestBody String orderStatus)
	{
		nbService.updateOrderStatus(orderId,orderStatus);
	}

	@GetMapping("/pay")
	public String pay(){

		return "payment done";
	}
     @PostMapping("/NetBankinginfo")
	public void enterupiaddress(@RequestBody NetBanking netBanking) {
		nbService.enterupiaddress(netBanking);
	}

     @GetMapping("/NetBankinginfo")
     public List<NetBanking> showupidetail()throws Exception{
    	return nbService.showupidetail();
     }

	 @DeleteMapping("/Delete/{id}")
	 public void removeaccount(@PathVariable Long id)
	 {
		 nbService.removeaccount(id);
	 }

	@PutMapping("/PaymentStatus/{id}")
	public ResponseEntity<NetBanking> updatePaymentStatusById(@PathVariable long id, @RequestBody String paymentStatus)
	{
		return nbService.updatePaymentStatusById(id,paymentStatus);
	}





}

