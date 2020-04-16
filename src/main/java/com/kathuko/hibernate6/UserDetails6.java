package com.kathuko.hibernate6;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class UserDetails6 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Automatically value will be generated
	private int userId;
	private String userName;

	// Another way of using collections Interface
	@ElementCollection // Creates table of UserDetails5_listOfAddress
	@JoinTable(name = "CompanyAddress6", joinColumns = @JoinColumn(name = "userId")) // Changes the name of the table
	@GenericGenerator(name = "increment-gen", strategy = "increment")
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "increment-gen", type = @Type(type = "long"))
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
