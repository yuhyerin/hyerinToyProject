package com.riri.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Entity
public class Account {
	@Id
	private Long accountId;
	
	@Column(length=45)
	private String name;
	
	@Column(length=100)
	private String email;
	
	@Column(length=512)
	private String password;
	
}
