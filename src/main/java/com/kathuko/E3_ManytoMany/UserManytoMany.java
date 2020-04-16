package com.kathuko.E3_ManytoMany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class UserManytoMany {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	@ManyToMany // Creating relation between User and Vehicle
	// Many user use Many cab vehicle
	// Primary key column of vehicle will be stored in UserOnetoOne table
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();

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

	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "UserDetails1 [userId=" + userId + ", userName=" + userName + "]";
	}

}
