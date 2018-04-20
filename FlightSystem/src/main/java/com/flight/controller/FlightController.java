package com.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flight.bean.Flight;
import com.flight.bean.TransFlight;
import com.flight.mapper.CityDistanceMapper;
import com.flight.service.CityDistanceService;
import com.flight.service.FlightService;
import com.flight.service.impl.FlightServiceImpl;
import com.sun.jdi.Method;

/*
 * 航班controller
 */
@Controller
public class FlightController {

	@Autowired
	private FlightService flightService;
	@Autowired
	private CityDistanceService cityDistanceService;
	
	//添加数据库数据的url
	@RequestMapping(value="/flight2")
	public String getFlights(String data)
	{
		List<Flight> result = flightService.updateFlight(data,"","");
		cityDistanceService.updateCityDistance();
		return "index";
	}
	//添加数据库数据的url
	@RequestMapping(value="/flight")
	@ResponseBody
	public List<Flight> getFlight(String depCity,String arrCity,String date)
	{
		List<Flight> result = flightService.updateFlight(depCity,arrCity,date);
		cityDistanceService.updateCityDistance();
		return result;
	}
	
	//查询直飞航班的url
	@RequestMapping(value="/searchFlight",method=RequestMethod.POST)
	@ResponseBody
	public List<Flight> getFlight(String depCity,String depAirport,String arrCity,String arrAirport,
			String flightType,String cabinType,String company,String date)
	{
		return flightService.getFlight(depCity.toUpperCase(), depAirport.toUpperCase(), arrCity.toUpperCase(),
				arrAirport.toUpperCase(), flightType, cabinType, company.toUpperCase(), date);
	}
	
	//查询中转航班的url
	@RequestMapping(value="/searchTransFlight",method=RequestMethod.POST)
	@ResponseBody
	public List<TransFlight> getTransFlight(String depCity,String depAirport,String arrCity,String arrAirport,
			String flightType,String cabinType,String company,String date,String transCity,String transAirport,
			String minTime,String maxTime)
	{
		return flightService.getTransFlight(depCity.toUpperCase(), depAirport.toUpperCase(), arrCity.toUpperCase(),
				arrAirport.toUpperCase(), flightType, cabinType, company.toUpperCase(), date, 
				transCity.toUpperCase(),transAirport.toUpperCase(), minTime, maxTime);
	}
	
	//原来是想用来爬数据的，但现在不能用
	@RequestMapping("/updateData")
	public String updateData()
	{
		flightService.updateData();
		return "index";
	}
}
