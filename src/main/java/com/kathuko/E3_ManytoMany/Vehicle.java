package com.kathuko.E3_ManytoMany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Vehicle {
	@Id
	private int vehicleId;
	private String vehicleName;

	@ManyToMany(mappedBy = "vehicles") // don't create mapping table
	private Collection<UserManytoMany> user = new ArrayList<UserManytoMany>();

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public Collection<UserManytoMany> getUser() {
		return user;
	}

	public void setUser(Collection<UserManytoMany> user) {
		this.user = user;
	}

}
