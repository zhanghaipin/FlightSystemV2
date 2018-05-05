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
	
	//手动添加数据库数据的url
	@RequestMapping(value="/flight2")
	public String getFlights(String data)
	{
		flightService.updateFlight(data,"","");
		cityDistanceService.updateCityDistance();
		return "index";
	}
	//自动添加数据库数据的url
	@RequestMapping(value="/flight")
	@ResponseBody
	public List<Flight> getFlight(String depCity,String arrCity,String date)
	{
		depCity=depCity.substring(depCity.length()-3);
		arrCity=arrCity.substring(arrCity.length()-3);
		List<Flight> result = flightService.updateFlight(depCity,arrCity,date);
		cityDistanceService.updateCityDistance();
		return result;
	}
	
	//查询直飞航班的url
	@RequestMapping(value="/searchFlight",method=RequestMethod.POST)
	@ResponseBody
	public List<Flight> getFlight(String depCity,String depAirport,String arrCity,String arrAirport,
			String flightType,String cabinType,String company,String date,String depTime,String arrTime,String order)
	{
		depCity=depCity.substring(depCity.length()-3);
		arrCity=arrCity.substring(arrCity.length()-3);
		if(depAirport!=null&&depAirport.length()>=3) {
			depAirport=depAirport.substring(depAirport.length()-3);
		}
		if(arrAirport!=null&&arrAirport.length()>=3) {
			arrAirport=arrAirport.substring(arrAirport.length()-3);
		}
		if(company!=null&&company.length()>=2) {
			company=company.substring(company.length()-2);
		}
		return flightService.getFlight(depCity, depAirport, arrCity,arrAirport, 
				flightType, cabinType, company, date,depTime,arrTime,order);
	}
	
	//查询中转航班的url
	@RequestMapping(value="/searchTransFlight",method=RequestMethod.POST)
	@ResponseBody
	public List<TransFlight> getTransFlight(String depCity,String depAirport,String arrCity,String arrAirport,
			String flightType,String cabinType,String company,String date,String transCity,String transAirport,
			String minTime,String maxTime,String depTime,String arrTime,String order,String transRatio)
	{
		/*
		 * depCity,arrCity,transCity:			出发/到达/中转城市，如 北京BJS
		 * depAirport,arrAirport,transAirport:	出发/到达/中转机场，如 首都国际机场PEK
		 * flightType：							飞机类型，2表大型机，1表中型机，0表小型机
		 * cabinType:							舱位类型，0表经济舱，1表头等舱
		 * company:								航空公司，如 南方航空CZ
		 * date:								出发日期，如 2018-06-04
		 * minTime:								中转最小时间，默认45分钟
		 * maxTime:								中转最大时间，默认120分钟
		 * depTime,arrTime:						出发/到达时间段，0表不限，1表00:00-06:00,2表06:00-12:00,3表12:00-18:00,4表18:00-24:00
		 * order:								排序方式,0表按价格排序，1表中转时间排序，2表中转距离排序，3表出发时间排序
		 * transRatio:							中转总距离和直飞距离的比值，默认1.6 
		 */
		depCity=depCity.substring(depCity.length()-3);
		arrCity=arrCity.substring(arrCity.length()-3);
		if(depAirport!=null&&depAirport.length()>=3) {
			depAirport=depAirport.substring(depAirport.length()-3);
		}
		if(arrAirport!=null&&arrAirport.length()>=3) {
			arrAirport=arrAirport.substring(arrAirport.length()-3);
		}
		if(company!=null&&company.length()>=2) {
			company=company.substring(company.length()-2);
		}
		if(transCity!=null&&transCity.length()>=3) {
			transCity=transCity.substring(transCity.length()-3);
		}
		if(transAirport!=null&&transAirport.length()>=3) {
			transAirport=transAirport.substring(transAirport.length()-3);
		}
		return flightService.getTransFlight(depCity, depAirport, arrCity,arrAirport,
				flightType,cabinType, company, date, transCity,	transAirport,minTime,
				maxTime,depTime,arrTime,order,transRatio);
	}
	
	//原来是想用来爬数据的，但现在不能用
	@RequestMapping("/updateData")
	public String updateData()
	{
		flightService.updateData();
		return "index";
	}
}
