package com.flight.service;

import java.util.List;

import com.flight.bean.Weather;

public interface WeatherService {

	public List<Weather> getWeatherByCity(String city);
}
