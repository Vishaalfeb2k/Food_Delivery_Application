package com.fooddelivery.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fooddelivery.payment.dto.NetBanking;

public interface NetBankingRepository extends JpaRepository<NetBanking, Long> {


    NetBanking findByIFSCcode(String IFSCcode);
}
