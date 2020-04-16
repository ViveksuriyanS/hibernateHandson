package com.kathuko.hibernate5;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
public class UserDetails5 {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // Automatically value will be generated
	private int userId;
	private String userName;
	@ElementCollection // Creates table of UserDetails5_listOfAddress
	@JoinTable(name = "CompanyAddress5", joinColumns = @JoinColumn(name = "user_Id")) // Changes the name of the table
	// new table primaryKey is userDetails_UserId to change we use JoinColumns
	// JoinTable -> change Table Name
	// JoinColumn -> change Column Name
	private Set<UserAddress> listOfAddress = new HashSet<UserAddress>();

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

	public Set<UserAddress> getListOfAddress() {
		return listOfAddress;
	}

	public void setListOfAddress(Set<UserAddress> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

	@Override
	public String toString() {
		return "UserDetails1 [userId=" + userId + ", userName=" + userName + "]";
	}

}
