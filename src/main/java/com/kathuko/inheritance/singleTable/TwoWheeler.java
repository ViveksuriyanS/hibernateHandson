package com.kathuko.inheritance.singleTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "2-Wheeler")
public class TwoWheeler extends Vehicle {
	private String steetingGear;

	public String getSteetingGear() {
		return steetingGear;
	}

	public void setSteetingGear(String steetingGear) {
		this.steetingGear = steetingGear;
	}

}
