package com.flight.service;

import java.util.List;

import com.flight.bean.Weather;

public interface ForecastService {

	public List<Double> forecast(List<Weather> dep,List<Weather> arr);
}
