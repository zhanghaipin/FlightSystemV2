package com.flight.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.bean.Airport;
import com.flight.bean.AirportExample;
import com.flight.bean.AirportExample.Criteria;
import com.flight.mapper.AirportMapper;
import com.flight.service.AirportService;

@Service
public class AirportServiceImpl implements AirportService {

	@Autowired
	public AirportMapper airportMapper;
	
	@Override
	public List<String> getAirportByCity(String city) {
		List<String> list=new ArrayList<>();
		AirportExample example = new AirportExample();
		example.setDistinct(true);
		Criteria criteria = example.createCriteria();
		criteria.andBelongCityEqualTo(city);
		List<Airport> airports = airportMapper.selectByExample(example);
		for (Airport airport : airports) {
			list.add(airport.getName()+airport.getCode());
		}
		return list;
	}

}
