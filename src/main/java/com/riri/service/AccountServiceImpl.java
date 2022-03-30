package com.riri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riri.dto.AccountDto;
import com.riri.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
//@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository accountRepo;
	
	@Override
	public void register(AccountDto dto) {
		accountRepo.save(dtoToEntity(dto));
//		System.out.println(accountRepo);
		
	}
	
}
