package com.kathuko.hqlNamedQueries;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

/**
 * @author viveksuriyan.s
 *
 */

@Entity
@NamedQuery(name = "MarvelDetails.byId", query = "from MarvelCharacters where id = ?1")
@NamedQuery(name = "MarvelDetails.byName", query = "from MarvelCharacters where name = ?1")
@NamedNativeQuery(name = "SuperHeroes", query = "select * from MarvelCharacters where id < 5", resultClass = MarvelCharacters.class)
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
