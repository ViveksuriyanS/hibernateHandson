package com.kathuko.crudOperations;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@org.hibernate.annotations.Entity(selectBeforeUpdate = true) // By default it takes care
// Value will be updated only if the object changes
// It is deprecated
public class MarvelCharacters {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;
	private String power;

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

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	@Override
	public String toString() {
		return "MarvelCharacters [id=" + id + ", name=" + name + ", power=" + power + "]";
	}

}
