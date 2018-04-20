package com.flight.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.bean.CityDistance;
import com.flight.mapper.CityDistanceMapper;
import com.flight.mapper.FlightMapper;
import com.flight.service.CityDistanceService;

@Service
public class CityDistanceServiceImpl implements CityDistanceService{

	@Autowired
	private CityDistanceMapper cityDistanceMapper;
	@Autowired
	private FlightMapper flightMapper;
	
	@Override
	public boolean updateCityDistance() {
		cityDistanceMapper.truncateTable();
		List<CityDistance> list = flightMapper.selectDistance();
		for (CityDistance cityDistance : list) {
			cityDistanceMapper.insert(cityDistance);
		}
		return true;
	}

}
