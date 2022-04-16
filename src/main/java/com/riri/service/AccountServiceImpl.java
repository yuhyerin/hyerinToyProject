package com.riri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.riri.dto.AccountDto;
import com.riri.entity.Account;
import com.riri.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

	/**
	 * 주입방식 2가지 
	 * 1) RequiredArgsConstructor -> 알아서 생성자를 통해 주입해줌. 
	 * 2) @Autowired 
	 * */
	
//	@Autowired
	private final AccountRepository accountRepo;
	
	private final PasswordEncoder encoder;
	
//	@Autowired
//	private AccountRepository accountRepo;
	
	@Override
	public AccountDto register(AccountDto dto) {
		dto.setPassword(encoder.encode(dto.getPassword()));
		Account entity = AccountService.dtoToEntity(dto);
		return AccountService.entityToDto(accountRepo.save(entity));
	}
	
}
