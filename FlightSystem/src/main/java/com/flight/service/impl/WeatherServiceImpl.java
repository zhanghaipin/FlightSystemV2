package com.flight.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.flight.bean.Weather;
import com.flight.service.WeatherService;
import com.flight.util.HttpClientUtil;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Value("${WEATHER_API}")
	private String WEATHER_API;
	@Value("${WEATHER_LOCATION}")
	private String WEATHER_LOCATION;
	
	@Override
	public List<Weather> getWeatherByCity(String city) {
		List<Weather> list=new ArrayList<>();
		
		String url=WEATHER_API+WEATHER_LOCATION+city;
		String json = HttpClientUtil.doGet(url);
		JSONObject result =JSON.parseObject(json);
		
		JSONObject heWeather = result.getJSONArray("HeWeather6").getJSONObject(0);
		JSONObject basic = heWeather.getJSONObject("basic");
		JSONArray daily = heWeather.getJSONArray("daily_forecast");
		for(int i=0;i<3;i++)
		{
			Weather weather=new Weather();
			
			weather.setLocation(basic.getString("location"));
			JSONObject w = daily.getJSONObject(i);
			weather.setDate(w.getDate("date"));
			weather.setHumidity(w.getDouble("hum"));
			weather.setMinTmp(w.getDouble("tmp_min"));
			weather.setMaxTmp(w.getDouble("tmp_max"));
			weather.setPcpn(w.getDouble("pcpn"));
			weather.setPop(w.getDouble("pop"));
			weather.setVis(w.getDouble("vis"));
			weather.setWindSpeed(w.getDouble("wind_spd"));
			
			list.add(weather);
		}
		return list;
	}

}
