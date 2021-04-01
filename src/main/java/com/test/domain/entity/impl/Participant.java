package com.test.domain.entity.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class Participant {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String userName;

	public Long getUserId() {
		return userId;
	}

//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
