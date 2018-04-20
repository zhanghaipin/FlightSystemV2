package com.flight.service.impl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.flight.bean.City;
import com.flight.bean.CityDistance;
import com.flight.bean.CityDistanceExample;
import com.flight.bean.CityExample;
import com.flight.bean.Flight;
import com.flight.bean.FlightExample;
import com.flight.bean.FlightExample.Criteria;
import com.flight.bean.TransFlight;
import com.flight.mapper.CityDistanceMapper;
import com.flight.mapper.CityMapper;
import com.flight.mapper.FlightMapper;
import com.flight.service.FlightService;
import com.flight.util.HttpClientUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
/*
 * 获取航班信息
 */
@Service
public class FlightServiceImpl implements FlightService{

	
	@Value("${FLIGHT_API}")
	private String FLIGHT_API;
	@Value("${FLIGHT_DCITY}")
	private String FLIGHT_DCITY;//出发城市参数
	@Value("${FLIGHT_ACITY}")
	private String FLIGHT_ACITY;//到达城市参数
	@Value("${FLIGHT_DATE}")
	private String FLIGHT_DATE;//起飞时间参数
	@Value("${FLIGHT_PARAM}")
	private String FLIGHT_PARAM;
	@Value("${MIN_TRANS_TIME}")
	private int MIN_TRANS_TIME;//最小中转时间
	@Value("${MAX_TRANS_TIME}")
	private int MAX_TRANS_TIME;//最大中转时间
	@Value("${TRANS_DISTANCE_RATIO}")
	private double TRANS_DISTANCE_RATIO;//中转距离比例
	
	
	@Autowired
	private CityMapper cityMapper;
	@Autowired
	private FlightMapper flightMapper;
	@Autowired
	private CityDistanceMapper cityDistanceMapper;

	//增加数据到数据库
	@Override
	public List<Flight> updateFlight(String depCity, String arrCity, String date) {
		List<Flight> list=new ArrayList<>();
		String pageUrl=FLIGHT_API+FLIGHT_DCITY+depCity+FLIGHT_ACITY+arrCity+FLIGHT_DATE+date+FLIGHT_PARAM;
		String json =depCity;// HttpClientUtil.doGet(pageUrl).trim();
		json=json.substring(21, json.length()-4).trim();
        JSONObject result =JSON.parseObject(json);
        if(result.getInteger("error")==0)//有相应数据
        {
        	JSONObject data=result.getJSONObject("data");
	        JSONArray flights = data.getJSONArray("flight");
	        
	        JSONObject planes = data.getJSONObject("flightTypeMap");
	        JSONObject companys = data.getJSONObject("aircodeNameMap");
	        JSONObject airports = data.getJSONObject("airportMap");
	        
	        Map<String, String> planeMap=new HashMap<>();//飞机型号对应大小
	        Map<String, String> companyMap=new HashMap<>();//航空公司及对应的公司缩写
	        Map<String, String> airportMap=new HashMap<>();//飞机场名称及对应的缩写
	        
	        JSONArray smallPlane = planes.getJSONArray("small");
	        for (int i = 0; i < smallPlane.size(); i++) {
				planeMap.put(smallPlane.getString(i),"小型机");
			} 
	        JSONArray middlePlane = planes.getJSONArray("middle");
	        for (int i = 0; i < middlePlane.size(); i++) {
				planeMap.put(middlePlane.getString(i),"中型机");
			} 
	        JSONArray largePlane = planes.getJSONArray("large");
	        for (int i = 0; i < largePlane.size(); i++) {
				planeMap.put(largePlane.getString(i),"大型机");
			}
	        
	        for (String company : companys.keySet()) {
				companyMap.put(company,companys.getString(company));
			}
	        for (String airport : airports.keySet()) {
	        	airportMap.put(airport,airports.getString(airport));
	        }
	        
	        for (int i = 0; i < flights.size(); i++) {//遍历航班
	        	Flight f=new Flight();
				JSONObject flight = flights.getJSONObject(i);
				JSONObject cabin = flight.getJSONObject("cabin");
				
				f.setArrCity(data.getString("arrCityName"));
				f.setDepCity(data.getString("depCityName"));
				f.setArrCityCode(data.getString("arrCityCode"));
				f.setDepCityCode(data.getString("depCityCode"));
				
				f.setCompanyCode(flight.getString("airlineCode"));
				f.setArrAirportCode(flight.getString("arrAirport"));
				f.setArrTerm(flight.getString("arrTerm"));
				String arrTime=flight.getString("arrTime");
				f.setArrDate(arrTime.substring(0,10));
				f.setArrTime(arrTime.substring(11));
				f.setBuildPrice(flight.getIntValue("buildPrice"));
				f.setDepAirportCode(flight.getString("depAirport"));
				f.setDepTerm(flight.getString("depTerm"));
				String depTime=flight.getString("depTime");
				f.setDepDate(depTime.substring(0, 10));
				f.setDepTime(depTime.substring(11));
				f.setFlightCode(flight.getString("flightNo"));
				f.setPlaneType(flight.getString("flightType"));
				f.setStop(flight.getIntValue("stop"));
				f.setFlightType(planeMap.get(f.getPlaneType()));
				
				try {
					Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(depTime);
					Date date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(arrTime);
					int time=(int) ((date2.getTime()-date1.getTime())/60000);
					f.setTimeUse(time);
					if(i==0) {
						f.setDistance(time*11);
					}else {
						f.setDistance(list.get(0).getDistance());
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				f.setBasePrice(cabin.getIntValue("basicCabinPrice"));
				f.setDiscount(cabin.getIntValue("bestDiscount"));
				f.setTruePrice(cabin.getIntValue("bestPrice"));
				f.setCabinType(cabin.getString("specialType").indexOf("经济")==-1?"头等舱":"经济舱");
				f.setComment(cabin.getString("specialAttributes"));
				if(cabin.getString("cabinNum")!=null) {
					f.setTicketNum(Integer.parseInt(cabin.getString("cabinNum")));
				}
				
				f.setArrAirport(airportMap.get(f.getArrAirportCode()));
				f.setDepAirport(airportMap.get(f.getDepAirportCode()));
				f.setCompany(companyMap.get(f.getCompanyCode()));
				
				flightMapper.insert(f);
				list.add(f);
	        }
		}
		return list;
	}


	//用于自动添加数据到数据库，不过使用for循环频繁调用数据接口会导致调用接口失效，
	@Override
	public boolean updateData() {
		CityExample example=new CityExample();
		example.setDistinct(true);
		List<City> citys = cityMapper.selectByExample(example);
		int len=3;//citys.size();
		String date="2018-04-23";
		for(int i=0;i<len;i++)
		{
			for(int j=0;j<len;j++)
			{
				if(j!=i)
				{
					updateFlight(citys.get(i).getCode(),citys.get(j).getCode(),date);
				}
			}
		}
		return true;
	}


	//查询直飞航班
	@Override
	public List<Flight> getFlight(String depCity, String depAirport, String arrCity, String arrAirport,
			String flightType, String cabinType, String company, String date) 
	{
		List<Flight> list=new ArrayList<>();
		FlightExample example = new FlightExample();
		example.setDistinct(true);
		Criteria criteria = example.createCriteria();
		criteria.andDepCityCodeEqualTo(depCity);
		criteria.andArrCityCodeEqualTo(arrCity);
		criteria.andDepDateEqualTo(date);
		if(depAirport!=null&&!("".equals(depAirport.trim())))
		{
			criteria.andDepAirportCodeEqualTo(depAirport);
		}
		if(arrAirport!=null&&!("".equals(arrAirport.trim())))
		{
			criteria.andArrAirportCodeEqualTo(arrAirport);
		}
		if(flightType!=null&&!("".equals(flightType.trim())))
		{
			criteria.andFlightTypeEqualTo(flightType);
		}
		if(cabinType!=null&&!("".equals(cabinType.trim())))
		{
			criteria.andCabinTypeEqualTo(cabinType);
		}
		if(company!=null&&!("".equals(company.trim())))
		{
			criteria.andCompanyCodeEqualTo(company);
		}
		
		list=flightMapper.selectByExample(example);
		return list;
	}

	//查询中转航班
	@Override
	public List<TransFlight> getTransFlight(String depCity, String depAirport, String arrCity, String arrAirport,
			String flightType, String cabinType, String company, String date, String transCity,String transAirport,
			String minTime,	String maxTime) 
	{
		List<TransFlight> list=new ArrayList<>();
		if(transCity!=null&&!("".equals(transCity.trim())))
		{
			//有中转城市
			list   =  getFlightByTrans(depCity, depAirport, arrCity, arrAirport, flightType, cabinType, company, date, transCity,transAirport, minTime, maxTime);
		}else {
			//无中转城市
			list=getFlightWithoutTrans(depCity, depAirport, arrCity, arrAirport, flightType, cabinType, company, date, transCity,transAirport, minTime, maxTime);
		}
		return list;
	}

	//已知中转城市情况下
	public List<TransFlight> getFlightByTrans(String depCity, String depAirport, String arrCity, String arrAirport,
			String flightType, String cabinType, String company, String date, String transCity,String transAirport,
			String minTime,	String maxTime) 
	{
		List<TransFlight> list=new ArrayList<>();
		List<Flight> firstList =getFlight(depCity, depAirport, transCity, transAirport, flightType, cabinType, company, date);
		List<Flight> secondList=getFlight(transCity, transAirport, arrCity, arrAirport, flightType, cabinType, company, date);
		for(int i=0;i<firstList.size();i++)
		{
			for(int j=0;j<secondList.size();j++)
			{
				String datetime1=firstList.get(i).getArrDate()+" "+firstList.get(i).getArrTime();
				String datetime2=secondList.get(j).getDepDate()+" "+secondList.get(j).getDepTime();
				try {
					Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(datetime1);
					Date date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(datetime2);
					int time=(int) ((date2.getTime()-date1.getTime())/60000);
					int minTrans=MIN_TRANS_TIME;
					int maxTrans=MAX_TRANS_TIME;
					if(minTime!=null&&!("".equals(minTime.trim())))
					{
						minTrans=Integer.parseInt(minTime);
					}
					if(maxTime!=null&&!("".equals(maxTime.trim())))
					{
						maxTrans=Integer.parseInt(maxTime);
					}
					if(time>minTrans&&time<maxTrans)
					{
						//符合中转时间选项
						list.add(new TransFlight(firstList.get(i),secondList.get(j),String.valueOf(time)));
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	//未知中转城市情况
	public List<TransFlight> getFlightWithoutTrans(String depCity, String depAirport, String arrCity, String arrAirport,
			String flightType, String cabinType, String company, String date, String transCity,
			String transAirport,String minTime,	String maxTime) 
	{
		List<TransFlight> list=new ArrayList<>();		//存放结果集
		Map<String,Integer> distanceMap=new HashMap<>();//存放各城市间距离信息
		
		CityExample cityExample = new CityExample();
		cityExample.setDistinct(true);
		List<City> cityList=cityMapper.selectByExample(cityExample);//存放所有城市
		
		//初始化各城市距离信息
		CityDistanceExample example = new CityDistanceExample();
		example.setDistinct(true);
		List<CityDistance> distances = cityDistanceMapper.selectByExample(example);
		for (CityDistance distance : distances) {
			distanceMap.put(distance.getAcityCode()+distance.getBcityCode(), distance.getDistance());
		}
		
		//遍历每个城市，若符合距离条件，则作为中转城市
		for (City city : cityList) {
			List<TransFlight> transList=new ArrayList<>();
			int firstDistance =-1;
			int secondDistance=-1;
			if(!(city.getCode().equals(depCity)))
			{
				if((distanceMap.get(depCity+city.getCode()))!=null) {
					firstDistance=distanceMap.get(depCity+city.getCode());
				}
			}
			if(!(city.getCode().equals(arrCity)))
			{
				if((distanceMap.get(city.getCode()+arrCity))!=null) {
					secondDistance=distanceMap.get(city.getCode()+arrCity);
				}
			}
			//可以中转
			if(firstDistance!=-1&&secondDistance!=-1)
			{
				int transDistance=firstDistance+secondDistance;
				if(transDistance<(distanceMap.get(depCity+arrCity)*TRANS_DISTANCE_RATIO))
				{
					//符合距离条件
					transList=getFlightByTrans(depCity, depAirport, arrCity, arrAirport, flightType, cabinType, company, date, city.getCode(),transAirport, minTime, maxTime);
				}
			}
			list.addAll(transList);
		}
		return list;
	}
}
