package com.kathuko.HibernateDemo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Embeddable will store the values in the same parent table
@Entity
public class Cast {
	@Id // will be used only if we use @Entity
	@GeneratedValue(strategy = GenerationType.AUTO) // Used to auto set the value
	private int id;
	private String name;
	private int age;
	@Temporal(TemporalType.DATE)
	private Date dob;
	private String country;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Cast [id=" + id + ", name=" + name + ", age=" + age + ", dob=" + dob + ", country=" + country + "]";
	}

}
