package com.riri.security.entity;

import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.riri.dto.AccountDto;
import com.riri.entity.Account;
import com.riri.service.AccountService;

import java.util.Set;

@ToString
public class MemberUser extends User {
    
    private AccountDto accountDto;
    
    public MemberUser(Account member, Set<GrantedAuthority> grantedAuthorities) {
        super(member.getEmail(), member.getPassword(), grantedAuthorities);
        this.accountDto = AccountService.entityToDto(member);
    }
    
    public AccountDto getMemberDto() {
        return accountDto;
    }
    
}
