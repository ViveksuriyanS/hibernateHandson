package com.kathuko.hibernate4;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity()
public class UserDetails4 {
	@EmbeddedId // Combined primary Key
	private LoginId userId;
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LoginId getUserId() {
		return userId;
	}

	public void setUserId(LoginId userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserDetails1 [userId=" + userId + ", userName=" + userName + "]";
	}

}
