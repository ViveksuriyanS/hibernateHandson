package com.kathuko.E2_OnetoMany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
	@Id
	private int vehicleId;
	private String vehicleName;

	@ManyToOne
	private UserOnetoMany user;

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

	public UserOnetoMany getUser() {
		return user;
	}

	public void setUser(UserOnetoMany user) {
		this.user = user;
	}

}
