package com.fooddelivery.payment.configuration;

import com.fooddelivery.payment.dto.NetBanking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

public class PaymentUserDetail implements UserDetails {


    @Autowired
   private NetBanking netBanking;

    public PaymentUserDetail(NetBanking netBanking) {
        super();
        this.netBanking = netBanking;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        HashSet<SimpleGrantedAuthority> set = new HashSet<>();
        set.add(new SimpleGrantedAuthority(this.netBanking.getRole()));

        return set;
    }

    @Override
    public String getPassword() {
        return this.netBanking.getUPIid();
    }

    @Override
    public String getUsername() {
        return this.netBanking.getIFSCcode();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
