package com.flight.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.bean.City;
import com.flight.bean.CityExample;
import com.flight.mapper.CityMapper;
import com.flight.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityMapper cityMapper;
	
	@Override
	public List<String> getAllCity() {
		List<String> list=new ArrayList<>();
		CityExample example=new CityExample();
		example.setDistinct(true);
		List<City> citys = cityMapper.selectByExample(example);
		for (City city : citys) {
			list.add(city.getName().trim()+city.getCode().trim());
		}
		return list;
	}

}
