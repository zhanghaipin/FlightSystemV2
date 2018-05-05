package com.flight.service.impl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSInput;

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
		String json =depCity;//HttpClientUtil.doGet(pageUrl).trim();
		json=json.substring(22, json.length()-4).trim();
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
	        
	        JSONArray smallPlane = planes.getJSONArray("small");//小型机
	        for (int i = 0; i < smallPlane.size(); i++) {
				planeMap.put(smallPlane.getString(i),"0");
			} 
	        JSONArray middlePlane = planes.getJSONArray("middle");//中型机
	        for (int i = 0; i < middlePlane.size(); i++) {
				planeMap.put(middlePlane.getString(i),"1");
			} 
	        JSONArray largePlane = planes.getJSONArray("large");//大型机
	        for (int i = 0; i < largePlane.size(); i++) {
				planeMap.put(largePlane.getString(i),"2");
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
				String flightType=planeMap.get(f.getPlaneType());
				f.setFlightType(flightType==null?"0":flightType);
				
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
				f.setCabinType(cabin.getString("specialType").indexOf("经济")==-1?"1":"0");
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


	//用于自动添加数据到数据库，不过使用for循环频繁调用数据接口会导致接口限制，
	@Override
	public boolean updateData() {
		CityExample example=new CityExample();
		example.setDistinct(true);
		List<City> citys = cityMapper.selectByExample(example);
		int len=3;//citys.size();
		String date="2018-05-23";
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
	public List<Flight> getFlight(String depCity, String depAirport, String arrCity, 
			String arrAirport,String flightType, String cabinType, String company, 
			String date,String depTime,String arrTime,String order) 
	{
		List<Flight> list=new ArrayList<>();
		FlightExample example = new FlightExample();
		example.setDistinct(true);
		Criteria criteria = example.createCriteria();
		criteria.andDepCityCodeEqualTo(depCity.toUpperCase());
		criteria.andArrCityCodeEqualTo(arrCity.toUpperCase());
		criteria.andDepDateEqualTo(date);
		if(depAirport!=null&&!("".equals(depAirport.trim())))
		{
			criteria.andDepAirportCodeEqualTo(depAirport.toUpperCase());
		}
		if(arrAirport!=null&&!("".equals(arrAirport.trim())))
		{
			criteria.andArrAirportCodeEqualTo(arrAirport.toUpperCase());
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
			criteria.andCompanyCodeEqualTo(company.toUpperCase());
		}
				
		list=flightMapper.selectByExample(example);
		int depMin;int depMax;int arrMin;int arrMax;
		//筛选出发时间段
		switch (depTime) {
			case "1"://00:00~06:00
				depMin=0;depMax=360;break;
			case "2"://06:00~12:00
				depMin=360;depMax=720;break;
			case "3"://12:00~18:00
				depMin=720;depMax=1080;break;
			case "4"://18:00~24:00
				depMin=1080;depMax=1440;break;
			default:
				depMin=0;depMax=1440;break;
		}
		//筛选到达时间段
		switch (arrTime) {
			case "1"://00:00~06:00
				arrMin=0;arrMax=360;break;
			case "2"://06:00~12:00
				arrMin=360;arrMax=720;break;
			case "3"://12:00~18:00
				arrMin=720;arrMax=1080;break;
			case "4"://18:00~24:00
				arrMin=1080;arrMax=1440;break;
			default:
				arrMin=0;arrMax=1440;break;
		}
		//排除不符合时间段的航班记录
		List<Flight> removeList=new ArrayList<>(); 
		for (int i = 0; i < list.size(); i++) {
			Flight f=list.get(i);
			int dep=Integer.parseInt(f.getDepTime().substring(0, 2))*60+Integer.parseInt(f.getDepTime().substring(3,5));
			int arr=Integer.parseInt(f.getArrTime().substring(0, 2))*60+Integer.parseInt(f.getArrTime().substring(3,5));
			if(dep>depMax||dep<depMin||arr>arrMax||arr<arrMin) {
				removeList.add(f);
			}
		}
		list.removeAll(removeList);
		//排序
		switch (order) {
			case "1"://飞行时间排序
				Collections.sort(list, new Comparator<Flight>() {  
		            @Override  
		            public int compare(Flight f1, Flight f2) {  
		                int i = f1.getTimeUse()-f2.getTimeUse();
		                if(i == 0){  
		                	return f1.getTruePrice()-f2.getTruePrice();
		                }  
		                return i;  
		            }  
		        });  
				break;
//			case "2"://出发时间排序
//				Collections.sort(list, new Comparator<Flight>() {  
//		            @Override  
//		            public int compare(Flight f1, Flight f2) {  
//		                int i = f1.getDepTime()-f2.getDepTime();
//		                if(i == 0){  
//		                	return f1.getTruePrice()-f2.getTruePrice();
//		                }  
//		                return i;  
//		            }  
//		        });  
//				break;
			default://价格排序
				Collections.sort(list, new Comparator<Flight>() {  
		            @Override  
		            public int compare(Flight f1, Flight f2) {  
		                int i = f1.getTruePrice()-f2.getTruePrice();
		                if(i == 0){  
		                	return f1.getTimeUse()-f2.getTimeUse();
		                }  
		                return i;  
		            }  
		        });  
				break;
	}
		return list;
	}

	//查询中转航班
	@Override
	public List<TransFlight> getTransFlight(String depCity,String depAirport,String arrCity,String arrAirport,
			String flightType,String cabinType,String company,String date,String transCity,String transAirport,
			String minTime,String maxTime,String depTime,String arrTime,String order,String transRatio)
	{
		List<TransFlight> list=new ArrayList<>();
		if(transCity!=null&&!("".equals(transCity.trim())))
		{
			//有中转城市
			list   =  getFlightByTrans(depCity, depAirport, arrCity, arrAirport, flightType, cabinType, company, date, transCity,transAirport, minTime, maxTime,depTime,arrTime,order,transRatio);
		}else {
			//无中转城市
			list=getFlightWithoutTrans(depCity, depAirport, arrCity, arrAirport, flightType, cabinType, company, date, transCity,transAirport, minTime, maxTime,depTime,arrTime,order,transRatio);
		}
		switch (order) {
			case "1"://中转时间排序
				Collections.sort(list, new Comparator<TransFlight>() {  
		            @Override  
		            public int compare(TransFlight f1, TransFlight f2) {  
		                int i = f1.getTransTime()-f2.getTransTime();
		                if(i == 0){  
		                	return f1.getTransPrice()-f2.getTransPrice();
		                }  
		                return i;  
		            }  
		        });  
				break;
			case "2"://中转距离排序
				Collections.sort(list, new Comparator<TransFlight>() {  
		            @Override  
		            public int compare(TransFlight f1, TransFlight f2) {  
		                int i = f1.getTransDistance()-f2.getTransDistance();
		                if(i == 0){  
		                	return f1.getTransPrice()-f2.getTransPrice();
		                }  
		                return i;  
		            }  
		        });  		
				break;
			default://总价格排序
				Collections.sort(list, new Comparator<TransFlight>() {  
		            @Override  
		            public int compare(TransFlight f1, TransFlight f2) {  
		                int i = f1.getTransPrice()-f2.getTransPrice();
		                if(i == 0){  
		                	return f1.getTransTime()-f2.getTransTime();
		                }  
		                return i;  
		            }  
		        });  
				break;
		}
		return list;
	}

	//已知中转城市情况下
	public List<TransFlight> getFlightByTrans(String depCity, String depAirport, String arrCity, String arrAirport,
			String flightType, String cabinType, String company, String date, String transCity,String transAirport,
			String minTime,	String maxTime,String depTime,String arrTime,String order,String transRatio) 
	{
		List<TransFlight> list=new ArrayList<>();
		List<Flight> firstList =getFlight(depCity, depAirport, transCity, transAirport, flightType, cabinType, company, date,depTime,"0",order);
		List<Flight> secondList=getFlight(transCity, transAirport, arrCity, arrAirport, flightType, cabinType, company, date,"0",arrTime,order);
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
						Flight first=firstList.get(i);
						Flight second=secondList.get(j);
						Integer transPrice=first.getTruePrice()+second.getTruePrice();
						Integer transDistance=first.getDistance()+second.getDistance();
						list.add(new TransFlight(first,second,time,transPrice,transDistance));
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
			String transAirport,String minTime,	String maxTime,String depTime,String arrTime,String order,String transRatio)
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
				if(transRatio!=null&&!transRatio.equals("")) {
					TRANS_DISTANCE_RATIO=Double.parseDouble(transRatio);
				}
				if(transDistance<(distanceMap.get(depCity+arrCity)*TRANS_DISTANCE_RATIO))
				{
					//符合距离条件
					transList=getFlightByTrans(depCity, depAirport, arrCity, arrAirport, flightType, cabinType, company, date, city.getCode(),transAirport, minTime, maxTime,depTime,arrTime,order,transRatio);
				}
			}
			list.addAll(transList);
		}
		return list;
	}


	@Override
	public Flight getFlightByCode(String flightCode) {
		FlightExample example = new FlightExample();
		example.setDistinct(true);
		Criteria criteria = example.createCriteria();
		criteria.andFlightCodeEqualTo(flightCode.trim());
		List<Flight> flight = flightMapper.selectByExample(example);
		return flight.get(0);
	}
}
