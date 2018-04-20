package com.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight.service.CityDistanceService;

@Controller
public class CityDistanceController {

	@Autowired
	private CityDistanceService cityDistanceService;
	
	@RequestMapping("/updateDistance")
	public String updateDistance()
	{
		//更新city_distance表数据
		boolean flag=cityDistanceService.updateCityDistance();
		return "index";
	}
}
