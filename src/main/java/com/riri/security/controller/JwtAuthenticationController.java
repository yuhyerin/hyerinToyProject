package com.riri.security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.riri.entity.Account;
import com.riri.security.dto.JwtRequest;
import com.riri.security.dto.JwtResponse;
import com.riri.security.service.JwtUserDetailsService;
import com.riri.security.util.JwtTokenUtil;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class JwtAuthenticationController {
    
    private final JwtTokenUtil jwtTokenUtil;
    
    private final JwtUserDetailsService userDetailService;
    
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        final Account member = userDetailService.authenticateByEmailAndPassword
                                                       (authenticationRequest.getEmail(),
                                                        authenticationRequest.getPassword());
    	
        final String token = jwtTokenUtil.generateToken(member.getEmail());
        return ResponseEntity.ok(new JwtResponse(token));
    }
    
}

