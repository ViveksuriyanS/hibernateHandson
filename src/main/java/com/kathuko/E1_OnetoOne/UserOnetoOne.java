package com.kathuko.E1_OnetoOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "UserDetails")
public class UserOnetoOne {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	@OneToOne // Creating relation between User and Vehicle
	// One user owns one vehicle
	// Primary key column of vehicle will be stored in UserOnetoOne table
	@JoinColumn(name = "VehicleX_Id") // change the column name
	private VehicleX vehicle;

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

	public VehicleX getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleX vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "UserDetails1 [userId=" + userId + ", userName=" + userName + "]";
	}

}
