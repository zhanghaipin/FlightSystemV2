package com.flight.bean;

public class TransFlight {

	
	private Flight firstFlight;
	private Flight secondFlight;
	private Integer transTime;
	private Integer transPrice;
	private Integer transDistance;
	public TransFlight(Flight firstFlight, Flight secondFlight, Integer transTime, Integer transPrice,
			Integer transDistance) {
		super();
		this.firstFlight = firstFlight;
		this.secondFlight = secondFlight;
		this.transTime = transTime;
		this.transPrice = transPrice;
		this.transDistance = transDistance;
	}
	public TransFlight() {
		super();
	}
	public Flight getFirstFlight() {
		return firstFlight;
	}
	public void setFirstFlight(Flight firstFlight) {
		this.firstFlight = firstFlight;
	}
	public Flight getSecondFlight() {
		return secondFlight;
	}
	public void setSecondFlight(Flight secondFlight) {
		this.secondFlight = secondFlight;
	}
	public Integer getTransTime() {
		return transTime;
	}
	public void setTransTime(Integer transTime) {
		this.transTime = transTime;
	}
	public Integer getTransPrice() {
		return transPrice;
	}
	public void setTransPrice(Integer transPrice) {
		this.transPrice = transPrice;
	}
	public Integer getTransDistance() {
		return transDistance;
	}
	public void setTransDistance(Integer transDistance) {
		this.transDistance = transDistance;
	}
	
	
}
