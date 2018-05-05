package com.flight.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flight.bean.Flight;
import com.flight.bean.Weather;
import com.flight.service.FlightService;
import com.flight.service.ForecastService;
import com.flight.service.WeatherService;

@Controller
public class ForecastController {

	@Autowired
	private ForecastService forecastService;
	@Autowired
	private FlightService flightService;
	@Autowired
	private WeatherService weatherService;
	
	@RequestMapping("/forecast")
	public String forecaseFlight(String flightCode,Map map) throws ParseException
	{
		Flight flight = flightService.getFlightByCode(flightCode);
		Date depDate = new SimpleDateFormat("yyyy-MM-dd").parse(flight.getDepDate());
		long date=((depDate.getTime())-(System.currentTimeMillis()))/(1000*60*60*24);
		if(date<3&&date>=0)
		{
			//现在只能查询三天内的天气预报
			List<Weather> depWeather = weatherService.getWeatherByCity(flight.getDepCity());
			List<Weather> arrWeather = weatherService.getWeatherByCity(flight.getArrCity());
			List<Double> delayRate = forecastService.forecast(depWeather, arrWeather);
			map.put("depWeather", depWeather);
			map.put("arrWeather", arrWeather);
			map.put("delayRate", delayRate);
		}
		map.put("flight", flight);
		return "forecast";
	}
}
