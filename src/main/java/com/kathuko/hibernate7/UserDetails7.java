package com.kathuko.hibernate7;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
public class UserDetails7 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Automatically value will be generated
	private int userId;
	private String userName;

	// Creates table of UserDetails5_listOfAddress
	@ElementCollection(fetch = FetchType.EAGER)
	// Eager -> Even if session is closed value can be fetched
	// Lazy -> Once the session is closed cannot access getter method
	@JoinTable(name = "COMPANY_ADDRESS7", joinColumns = @JoinColumn(name = "USER_ID")) // Changes the name of the table
	private Collection<UserAddress> listOfAddress = new ArrayList<UserAddress>();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Collection<UserAddress> getListOfAddress() {
		return listOfAddress;
	}

	public void setListOfAddress(Collection<UserAddress> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

	@Override
	public String toString() {
		return "UserDetails1 [userId=" + userId + ", userName=" + userName + "]";
	}

}
