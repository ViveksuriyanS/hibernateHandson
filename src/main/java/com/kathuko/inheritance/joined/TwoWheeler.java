package com.kathuko.inheritance.joined;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle {
	private String steetingGear;

	public String getSteetingGear() {
		return steetingGear;
	}

	public void setSteetingGear(String steetingGear) {
		this.steetingGear = steetingGear;
	}

}
