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
		/**
		 * 빌더패턴 -> 왜쓸까? JPA랑 관련이 많음. 알고쓰세요!!!
		 * 
		 * ...영속성컨텍스트(영속계층)... DB 
		 * 영속계층에서 값이 변경되면 --> DB에도 알아서 변경이 반영이됨. 
		 * 
		 * 영속화 시점부터 모든값을 세팅해줘야함... 
		 * 값이 너무많으면 보기 어려움 new 생성자(col1, col2, col3, col4, col5, ... );
		 * 
		 * 빌더패턴은 객체를 반환하는 순간, 내가 원하는 형태로 초기화된 객체를 반환하는것을 보장해줌. 
		 * 애매한 상태의 객체(초기화되지않은) 가 내 코드에 존재하지 않는것임..... 
		 * */
		Account account = Account.builder()
				.accountId(999L)
				.name("유혜린")
				.email("hyerin77@naver.com")
				.password("password")
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
