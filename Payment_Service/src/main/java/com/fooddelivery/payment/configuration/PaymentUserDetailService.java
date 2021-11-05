package com.fooddelivery.payment.configuration;


import com.fooddelivery.payment.dto.NetBanking;
import com.fooddelivery.payment.repository.NetBankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PaymentUserDetailService implements UserDetailsService {
    @Autowired
    private NetBankingRepository netBankingRepository;



    @Override
    public UserDetails loadUserByUsername(String IFSCcode) throws UsernameNotFoundException {

        NetBanking netBanking = netBankingRepository.findByIFSCcode(IFSCcode);
        if(netBanking == null)
            throw new UsernameNotFoundException("not found");
        return new PaymentUserDetail(netBanking);

    }

}