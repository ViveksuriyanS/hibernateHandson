package com.kathuko.NotFoundAnnotation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Vehicle {
	@Id
	private int vehicleId;
	private String vehicleName;

	@ManyToOne
	@NotFound(action = NotFoundAction.EXCEPTION)
	// If vehicle is not used by any user, then while trying to find vehicle used by
	// users
	// It will throw exception
	private UserNotFound user;

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

	public UserNotFound getUser() {
		return user;
	}

	public void setUser(UserNotFound user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", user=" + user + "]";
	}

}
