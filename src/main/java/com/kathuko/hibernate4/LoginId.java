package com.kathuko.hibernate4;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class LoginId implements Serializable {

	private static final long serialVersionUID = 1L;
	private String emailId;
	private String loginId;
	private String mobileNo;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

}
