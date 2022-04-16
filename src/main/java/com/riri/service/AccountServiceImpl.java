package com.riri.service;

import org.springframework.beans.factory.annotation.Autowired;
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
	
//	@Autowired
//	private AccountRepository accountRepo;
	
	@Override
	public AccountDto register(AccountDto dto) {
		return entityToDto(accountRepo.save(dtoToEntity(dto)));
	}
	
}
