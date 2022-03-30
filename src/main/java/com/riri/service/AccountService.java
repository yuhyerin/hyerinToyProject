package com.riri.service;

import com.riri.dto.AccountDto;
import com.riri.entity.Account;

public interface AccountService {
	
	void register(AccountDto dto);
	
	default AccountDto entityToDto(Account entity) {
		return AccountDto.builder()
				.accountId(entity.getAccountId())
				.email(entity.getEmail())
				.name(entity.getName())
				.build();
	}
	
	default Account dtoToEntity(AccountDto dto) {
		return Account.builder()
				.accountId(dto.getAccountId())
				.email(dto.getEmail())
				.name(dto.getName())
				.password(dto.getPassword())
				.build();
	}
}
