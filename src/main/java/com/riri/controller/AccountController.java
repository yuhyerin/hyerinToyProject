package com.riri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riri.dto.AccountDto;
import com.riri.service.AccountService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AccountController {
	
//	@Autowired
	private final AccountService accountService;
	
	
	// 응답타입 Map파... Dto파... 
	
	// 회원가입용. 
	@PostMapping("/accounts")
	public ResponseEntity<AccountDto> signUp(@RequestBody AccountDto account){
		log.info(account.getEmail()+","+account.getName());
		log.info(accountService.toString());
		return new ResponseEntity<>(accountService.register(account), HttpStatus.OK);
	}
	
	@GetMapping("/test")
	public ResponseEntity<AccountDto> test(){
		log.info(">>> test controller ");
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
}
