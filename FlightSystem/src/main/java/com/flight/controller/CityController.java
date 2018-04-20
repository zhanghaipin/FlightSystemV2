package com.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flight.service.CityService;

/*
 * 城市controller
 */
@Controller
public class CityController {

	@Autowired
	private CityService cityService;
	
	@RequestMapping("/getAllCity")
	@ResponseBody
	public List<String> getAllCity()
	{
		return cityService.getAllCity();
	}
}
