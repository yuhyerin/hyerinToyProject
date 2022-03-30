package com.riri.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTest {

	@Autowired
	AccountService accountService;
	
	@Test
	void test() {
		accountService.register(null);
	}
}
