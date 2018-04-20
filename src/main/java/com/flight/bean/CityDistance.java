package com.flight.bean;

public class CityDistance {
    private Integer id;

    private String acity;

    private String acityCode;

    private String bcity;

    private String bcityCode;

    private Integer distance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAcity() {
        return acity;
    }

    public void setAcity(String acity) {
        this.acity = acity == null ? null : acity.trim();
    }

    public String getAcityCode() {
        return acityCode;
    }

    public void setAcityCode(String acityCode) {
        this.acityCode = acityCode == null ? null : acityCode.trim();
    }

    public String getBcity() {
        return bcity;
    }

    public void setBcity(String bcity) {
        this.bcity = bcity == null ? null : bcity.trim();
    }

    public String getBcityCode() {
        return bcityCode;
    }

    public void setBcityCode(String bcityCode) {
        this.bcityCode = bcityCode == null ? null : bcityCode.trim();
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}