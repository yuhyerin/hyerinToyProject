package com.riri.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.riri.entity.Account;
import com.riri.repository.AccountRepository;
import com.riri.security.entity.MemberUser;
import com.riri.security.entity.Role;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    
    private final PasswordEncoder passwordEncoder;
    
    private final AccountRepository memberRepository;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account member = memberRepository.findByEmail(email)
                                        .orElseThrow(() -> new UsernameNotFoundException(email));
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));
        if (email.equals("wjdtngh950@naver.com")) {
            grantedAuthorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        }
        
        return new MemberUser(member, grantedAuthorities);
    }
    
    public Account authenticateByEmailAndPassword(String email, String password) {
    	Account member = memberRepository.findByEmail(email)
                                        .orElseThrow(() -> new UsernameNotFoundException(email));
        
        if (!passwordEncoder.matches(password, member.getPassword())) {
            throw new BadCredentialsException("Password not matched");
        }
        
        return member;
    }
    
}
