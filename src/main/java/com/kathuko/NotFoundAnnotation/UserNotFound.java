package com.kathuko.NotFoundAnnotation;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class UserNotFound {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	@OneToMany // Creating relation between User and Vehicle
	// One user owns Many vehicle
	// Primary key column of vehicle will be stored in UserOnetoOne table
	@JoinTable(name = "User_Vehicle", 
	joinColumns = @JoinColumn(name = "UserId"), 
	inverseJoinColumns = @JoinColumn(name = "vehicleId"))
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
