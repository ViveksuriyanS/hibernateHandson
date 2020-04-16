package com.kathuko.hibernate6;

import javax.persistence.Embeddable;

@Embeddable // Added to existing table without new table
public class UserAddress {
	private String State;
	private String City;
	private String Street;
	private int pincode;

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "UserAddress [State=" + State + ", City=" + City + ", Street=" + Street + ", pincode=" + pincode + "]";
	}

}
