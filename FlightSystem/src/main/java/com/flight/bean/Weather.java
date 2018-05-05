package com.flight.bean;

import java.util.Date;

public class Weather {

	private String location;		//地点
	private Date date;				//日期
	private Double minTmp;			//最低温度
	private Double maxTmp;			//最高温度
	private Double windSpeed;		//风速 公里/小时
	private Double humidity;		//湿度
	private Double pcpn;			//降水量
	private Double pop;			//降水概率
	private Double vis;			//能见度 单位：公里
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getMinTmp() {
		return minTmp;
	}
	public void setMinTmp(Double minTmp) {
		this.minTmp = minTmp;
	}
	public Double getMaxTmp() {
		return maxTmp;
	}
	public void setMaxTmp(Double maxTmp) {
		this.maxTmp = maxTmp;
	}
	public Double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(Double windSpeed) {
		this.windSpeed = windSpeed;
	}
	public Double getHumidity() {
		return humidity;
	}
	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}
	public Double getPcpn() {
		return pcpn;
	}
	public void setPcpn(Double pcpn) {
		this.pcpn = pcpn;
	}
	public Double getPop() {
		return pop;
	}
	public void setPop(Double pop) {
		this.pop = pop;
	}
	public Double getVis() {
		return vis;
	}
	public void setVis(Double vis) {
		this.vis = vis;
	}
	
	
}
