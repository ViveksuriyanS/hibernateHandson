package com.kathuko.hibernate3;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity()
public class UserDetails3 {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // Automatically value will be generated
	private int userId;
	private String userName;
	@Embedded // Not mandatory if @Embeddable is defined
	@AttributeOverrides({ @AttributeOverride(name = "Street", column = @Column(name = "Home_Street_Name")),
			@AttributeOverride(name = "City", column = @Column(name = "Home_City_Name")),
			@AttributeOverride(name = "State", column = @Column(name = "Home_State_Name")),
			@AttributeOverride(name = "pincode", column = @Column(name = "Home_Pincode")) })
	private UserAddress HomeAddress;
	@Embedded // Not mandatory if @Embeddable is defined
	@AttributeOverrides({ @AttributeOverride(name = "Street", column = @Column(name = "Office_Street_Name")),
			@AttributeOverride(name = "City", column = @Column(name = "Office_City_Name")),
			@AttributeOverride(name = "State", column = @Column(name = "Office_State_Name")),
			@AttributeOverride(name = "pincode", column = @Column(name = "Office_Pincode")) })
	private UserAddress OfficeAddress;

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

	public UserAddress getHomeAddress() {
		return HomeAddress;
	}

	public void setHomeAddress(UserAddress homeAddress) {
		HomeAddress = homeAddress;
	}

	public UserAddress getOfficeAddress() {
		return OfficeAddress;
	}

	public void setOfficeAddress(UserAddress officeAddress) {
		OfficeAddress = officeAddress;
	}

	@Override
	public String toString() {
		return "UserDetails1 [userId=" + userId + ", userName=" + userName + "]";
	}

}
