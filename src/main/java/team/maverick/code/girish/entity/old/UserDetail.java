package team.maverick.code.girish.entity.old;
// Generated 29 Apr, 2018 4:20:19 PM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserDetail generated by hbm2java
 */
@Entity
@Table(name="user_detail")
public class UserDetail implements java.io.Serializable {

	@Column(name="user_id")
	@Id
	private String userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="last_active_time")
	private Date lastActiveTime;
	
	private Set carPoolSlots = new HashSet(0);
	private Set carPoolBookings = new HashSet(0);

	public UserDetail() {
	}

	public UserDetail(String userId) {
		this.userId = userId;
	}

	public UserDetail(String userId, String firstName, String lastName, Date lastActiveTime, Set carPoolSlots,
			Set carPoolBookings) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastActiveTime = lastActiveTime;
		this.carPoolSlots = carPoolSlots;
		this.carPoolBookings = carPoolBookings;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getLastActiveTime() {
		return this.lastActiveTime;
	}

	public void setLastActiveTime(Date lastActiveTime) {
		this.lastActiveTime = lastActiveTime;
	}

	public Set getCarPoolSlots() {
		return this.carPoolSlots;
	}

	public void setCarPoolSlots(Set carPoolSlots) {
		this.carPoolSlots = carPoolSlots;
	}

	public Set getCarPoolBookings() {
		return this.carPoolBookings;
	}

	public void setCarPoolBookings(Set carPoolBookings) {
		this.carPoolBookings = carPoolBookings;
	}

}