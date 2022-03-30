package com.riri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riri.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
