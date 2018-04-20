package com.flight.bean;

public class TransFlight {

	public TransFlight(Flight firstFlight, Flight secondFlight, String transTime) {
		super();
		this.firstFlight = firstFlight;
		this.secondFlight = secondFlight;
		this.transTime = transTime;
	}
	private Flight firstFlight;
	private Flight secondFlight;
	private String transTime;
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
	public String getTransTime() {
		return transTime;
	}
	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}
	public TransFlight() {
		super();
	}
	
}
