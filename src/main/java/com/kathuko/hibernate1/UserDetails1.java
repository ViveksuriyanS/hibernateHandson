package com.kathuko.hibernate1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

//Give different name to both entity(class) and table
@Entity(name = "User_Details1")
// Give new name to table, but entity(class) remains same
//@Table(name = "User_Detail1")
public class UserDetails1 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Automatically value will be generated
	@Column(name = "User_Id") // New column name
	private int userId;
	@Column(name = "User_Name")
	private String userName;
	@Temporal(TemporalType.DATE) // Only Date without TimeStamp
	@Column(name = "Joined_Date")
	private Date joinedDate;
	@Column(name = "Resign_Date")
	private Date lastDate;
	@Transient // This data will not be stored in the DB
	private long serviceDays; // join_date - resign_date
	@Lob // Store large object
	private String experience;

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public long getServiceDays() {
		return serviceDays;
	}

	public void setServiceDays(long serviceDays) {
		long diff = getJoinedDate().getTime() - getLastDate().getTime();

		this.serviceDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserDetails1 [userId=" + userId + ", userName=" + userName + ", joinedDate=" + joinedDate + "]";
	}

}
