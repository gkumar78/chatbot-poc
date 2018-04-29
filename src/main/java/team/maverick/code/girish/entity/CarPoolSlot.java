package team.maverick.code.girish.entity;
// Generated 29 Apr, 2018 4:20:19 PM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CarPoolSlot generated by hbm2java
 */
public class CarPoolSlot implements java.io.Serializable {

	private int slotId;
	private Destination destination;
	private UserDetail userDetail;
	private Integer totalSlot;
	private Integer freeSlot;
	private Date offerTime;
	private Integer price;
	private Date lastUpdateTime;
	private Set carPoolBookings = new HashSet(0);

	public CarPoolSlot() {
	}

	public CarPoolSlot(int slotId) {
		this.slotId = slotId;
	}

	public CarPoolSlot(int slotId, Destination destination, UserDetail userDetail, Integer totalSlot, Integer freeSlot,
			Date offerTime, Integer price, Date lastUpdateTime, Set carPoolBookings) {
		this.slotId = slotId;
		this.destination = destination;
		this.userDetail = userDetail;
		this.totalSlot = totalSlot;
		this.freeSlot = freeSlot;
		this.offerTime = offerTime;
		this.price = price;
		this.lastUpdateTime = lastUpdateTime;
		this.carPoolBookings = carPoolBookings;
	}

	public int getSlotId() {
		return this.slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public Destination getDestination() {
		return this.destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public Integer getTotalSlot() {
		return this.totalSlot;
	}

	public void setTotalSlot(Integer totalSlot) {
		this.totalSlot = totalSlot;
	}

	public Integer getFreeSlot() {
		return this.freeSlot;
	}

	public void setFreeSlot(Integer freeSlot) {
		this.freeSlot = freeSlot;
	}

	public Date getOfferTime() {
		return this.offerTime;
	}

	public void setOfferTime(Date offerTime) {
		this.offerTime = offerTime;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Set getCarPoolBookings() {
		return this.carPoolBookings;
	}

	public void setCarPoolBookings(Set carPoolBookings) {
		this.carPoolBookings = carPoolBookings;
	}

}