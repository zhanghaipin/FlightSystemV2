package com.flight.service;

import java.util.List;

import com.flight.bean.Flight;
import com.flight.bean.TransFlight;

public interface FlightService {

	public boolean updateData();
	
	public List<Flight> updateFlight(String depCity, String arrCity, String date);
	
	public List<Flight> getFlight(String depCity,String depAirport,String arrCity,String arrAirport,
			String flightType,String cabinType,String company,String date,String depTime,String arrTime,String order);
	
	public List<TransFlight> getTransFlight(String depCity,String depAirport,String arrCity,String arrAirport,
			String flightType,String cabinType,String company,String date,String transCity,String transAirport,
			String minTime,String maxTime,String depTime,String arrTime,String order,String transRatio);
}
