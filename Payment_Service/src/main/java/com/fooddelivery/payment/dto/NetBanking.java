package com.fooddelivery.payment.dto;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name="NetBankinginfo")
@Component
public class NetBanking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String IFSCcode;
	private String UPIid;
	private String bank;
	private String role = "UPI";
	private String name;
	private String paymentStatus;

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public NetBanking() {}
	public NetBanking(String iFSCcode, String uPIid, String bank, String role,String name,String paymentStatus) {
		super();
		this.IFSCcode = iFSCcode;
		this.UPIid = uPIid;
		this.bank = bank;
		this.role = role;
		this.name = name;
		this.paymentStatus=paymentStatus;

	}
	public String getIFSCcode() {
		return IFSCcode;
	}
	public void setIFSCcode(String iFSCcode) {
		IFSCcode = iFSCcode;
	}
	public String getUPIid() {
		return UPIid;
	}
	public void setUPIid(String uPIid) {
		UPIid = uPIid;
	}
	
	
}
