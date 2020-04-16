package com.kathuko.HibernateDemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

// Persistence class

@Entity // Makes the class as entity for mapping
@Table(name = "ShieldMarvel", uniqueConstraints = { @UniqueConstraint(columnNames = "Char_Name") }) // Changes the table
																									// name
public class Shield {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // GenerationType.IDENTITY
	private int marvelId;

	@Column(name = "Char_Name", unique = true, nullable = false) // Changes the column name
	private String name;

	@Column(name = "Special_Ability", unique = false, nullable = false, length = 100)
	private String power;

	@Column(name = "Rating", unique = false, nullable = false, length = 3)
	private int score;

//	@Transient will be used for temporary variable, will not be stored in table
	@OneToOne(targetEntity = Cast.class, fetch = FetchType.LAZY)
	private Cast castInfo;

	private boolean isAlive;

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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

//	public Shield(String name, String power, String score, boolean isAlive) {
//		super();
//		this.name = name;
//		this.power = power;
//		this.score = score;
//		this.isAlive = isAlive;
//	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getMarvelId() {
		return marvelId;
	}

	public void setMarvelId(int marvelId) {
		this.marvelId = marvelId;
	}

	public Cast getCastInfo() {
		return castInfo;
	}

	public void setCastInfo(Cast castInfo) {
		this.castInfo = castInfo;
	}

	@Override
	public String toString() {
		return "Shield [marvelId=" + marvelId + ", name=" + name + ", power=" + power + ", score=" + score
				+ ", castInfo=" + castInfo + ", isAlive=" + isAlive + "]";
	}

}


// Check optimistic lock and pessimistic lock