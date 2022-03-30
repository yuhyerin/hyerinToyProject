package com.riri.repository;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.riri.entity.Account;

@SpringBootTest
public class AccountRepositoryTests {

	@Autowired
	AccountRepository accountRepo;

	@Test
	@Transactional
	void insertTest() {
		Account account = Account.builder().accountId(999L).name("유혜린").email("hyerin77@naver.com").password("password")
				.build();
		Account saveResult = accountRepo.save(account);

		Account findResult = accountRepo.findById(account.getAccountId()).get();

		System.out.println(saveResult == findResult);

	}

	@Test
	void insertListTest() {
		java.util.List<Account> accountList = IntStream.rangeClosed(1, 200)
				.mapToObj(num -> Account.builder().accountId((long) num).name("테스트유저" + num)
						.email("테스트유저" + num + "@naver.com").password("password" + num).build())
				.collect(Collectors.toList());

		accountRepo.saveAll(accountList);
	}

	@Test
	void deleteTest() {
		accountRepo.deleteById(999L);
	}

	@Test
	void selectTest() {
		Account findResult = accountRepo.findById(77L).get();
		System.out.println(findResult);
	}
}
