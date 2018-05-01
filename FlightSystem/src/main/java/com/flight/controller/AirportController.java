package com.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flight.service.AirportService;

/*
 * 机场controller
 */
@Controller
public class AirportController {

	@Autowired
	private AirportService airportService;
	
	@RequestMapping("/getAirportByCity")
	@ResponseBody
	public List<String> getAirportByCity(@RequestParam String city)
	{
		//根据城市查找机场：http://localhost:8080/FlightSystem/getAirportByCity?city=北京BJS
		if(city!=null&&city.length()>3) {
			city=city.trim();
			city=city.substring(0, city.length()-3).trim();
		}
		return airportService.getAirportByCity(city);
	}
}
