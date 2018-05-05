package com.flight.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flight.bean.Weather;
import com.flight.service.ForecastService;

@Service
public class ForecastServiceImpl implements ForecastService {

	@Override
	public List<Double> forecast(List<Weather> dep, List<Weather> arr) {
		List<Double> list=new ArrayList<>();
		for(int i=0;i<dep.size();i++)
		{
//			private Integer minTmp;			//最低温度
//			private Integer maxTmp;			//最高温度
//			private Integer windSpeed;		//风速 公里/小时
//			private Integer humidity;		//湿度
//			private Double pcpn;			//降水量
//			private Integer pop;			//降水概率
//			private Integer vis;			//能见度 单位：公里
			Double rate = new Double(0.0);
			Weather depWeather = dep.get(i);
			Weather arrWeather = arr.get(i);
			
			//能见度
			double visRate=100.0/depWeather.getVis()+100.0/arrWeather.getVis();
			if(visRate>20)//平均高于10km忽略影响
			{
				rate=rate+visRate;
			}
			//高温度,35~50°影响率0~100%
			if(depWeather.getMaxTmp()>35)
			{
				double maxTmpRate=(Math.pow(depWeather.getMaxTmp(),2)/13-94);
				rate=rate+maxTmpRate;
			}
			if(arrWeather.getMaxTmp()>35)
			{
				double maxTmpRate=(Math.pow(arrWeather.getMaxTmp(),2)/13-94);
				rate=rate+maxTmpRate;
			}
			//低温度,-20~-40°影响率0~100%
			if(depWeather.getMinTmp()<-20)
			{
				double minTmpRate=(Math.pow(depWeather.getMinTmp(),2)/12-33);
				rate=rate+minTmpRate;
			}
			if(arrWeather.getMinTmp()<-20)
			{
				double minTmpRate=(Math.pow(arrWeather.getMinTmp(),2)/12-33);
				rate=rate+minTmpRate;
			}
			//风速
			if(depWeather.getWindSpeed()>25)
			{
				double depWindRate=0;
				rate=rate+depWindRate;
			}
			if(arrWeather.getWindSpeed()>25)
			{
				double arrWindRate=0;
				rate=rate+arrWindRate;
			}
			list.add(rate);
		}
		return list;
	}



}
