package com.riri.service;

import com.riri.dto.AccountDto;
import com.riri.entity.Account;

public interface AccountService {
	
	AccountDto register(AccountDto dto);
	
	static AccountDto entityToDto(Account entity) {
		return AccountDto.builder()
				.accountId(entity.getAccountId())
				.email(entity.getEmail())
				.name(entity.getName())
				.password(entity.getPassword())
				.build();
	}
	
	static Account dtoToEntity(AccountDto dto) {
		return Account.builder()
				.accountId(dto.getAccountId())
				.email(dto.getEmail())
				.name(dto.getName())
				.password(dto.getPassword())
				.build();
	}
}
