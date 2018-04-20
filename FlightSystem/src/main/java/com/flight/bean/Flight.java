package com.flight.bean;

public class Flight {
    private Integer id;

    private String flightCode;

    private String flightType;

    private String cabinType;

    private String planeType;

    private Integer timeUse;

    private Integer buildPrice;

    private Integer stop;

    private String stopCity;

    private String comment;

    private Integer basePrice;

    private Integer discount;

    private Integer truePrice;

    private Integer ticketNum;

    private String depCity;

    private String depCityCode;

    private String depAirport;

    private String depAirportCode;

    private String depTerm;

    private String arrCity;

    private String arrCityCode;

    private String arrAirport;

    private String arrAirportCode;

    private String arrTerm;

    private String company;

    private String companyCode;

    private String depDate;

    private String depTime;

    private String arrDate;

    private String arrTime;

    private String stopAirport;

    private Integer meal;

    private Integer distance;

    private Integer punctuality;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode == null ? null : flightCode.trim();
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType == null ? null : flightType.trim();
    }

    public String getCabinType() {
        return cabinType;
    }

    public void setCabinType(String cabinType) {
        this.cabinType = cabinType == null ? null : cabinType.trim();
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType == null ? null : planeType.trim();
    }

    public Integer getTimeUse() {
        return timeUse;
    }

    public void setTimeUse(Integer timeUse) {
        this.timeUse = timeUse;
    }

    public Integer getBuildPrice() {
        return buildPrice;
    }

    public void setBuildPrice(Integer buildPrice) {
        this.buildPrice = buildPrice;
    }

    public Integer getStop() {
        return stop;
    }

    public void setStop(Integer stop) {
        this.stop = stop;
    }

    public String getStopCity() {
        return stopCity;
    }

    public void setStopCity(String stopCity) {
        this.stopCity = stopCity == null ? null : stopCity.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Integer getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Integer basePrice) {
        this.basePrice = basePrice;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getTruePrice() {
        return truePrice;
    }

    public void setTruePrice(Integer truePrice) {
        this.truePrice = truePrice;
    }

    public Integer getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(Integer ticketNum) {
        this.ticketNum = ticketNum;
    }

    public String getDepCity() {
        return depCity;
    }

    public void setDepCity(String depCity) {
        this.depCity = depCity == null ? null : depCity.trim();
    }

    public String getDepCityCode() {
        return depCityCode;
    }

    public void setDepCityCode(String depCityCode) {
        this.depCityCode = depCityCode == null ? null : depCityCode.trim();
    }

    public String getDepAirport() {
        return depAirport;
    }

    public void setDepAirport(String depAirport) {
        this.depAirport = depAirport == null ? null : depAirport.trim();
    }

    public String getDepAirportCode() {
        return depAirportCode;
    }

    public void setDepAirportCode(String depAirportCode) {
        this.depAirportCode = depAirportCode == null ? null : depAirportCode.trim();
    }

    public String getDepTerm() {
        return depTerm;
    }

    public void setDepTerm(String depTerm) {
        this.depTerm = depTerm == null ? null : depTerm.trim();
    }

    public String getArrCity() {
        return arrCity;
    }

    public void setArrCity(String arrCity) {
        this.arrCity = arrCity == null ? null : arrCity.trim();
    }

    public String getArrCityCode() {
        return arrCityCode;
    }

    public void setArrCityCode(String arrCityCode) {
        this.arrCityCode = arrCityCode == null ? null : arrCityCode.trim();
    }

    public String getArrAirport() {
        return arrAirport;
    }

    public void setArrAirport(String arrAirport) {
        this.arrAirport = arrAirport == null ? null : arrAirport.trim();
    }

    public String getArrAirportCode() {
        return arrAirportCode;
    }

    public void setArrAirportCode(String arrAirportCode) {
        this.arrAirportCode = arrAirportCode == null ? null : arrAirportCode.trim();
    }

    public String getArrTerm() {
        return arrTerm;
    }

    public void setArrTerm(String arrTerm) {
        this.arrTerm = arrTerm == null ? null : arrTerm.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode == null ? null : companyCode.trim();
    }

    public String getDepDate() {
        return depDate;
    }

    public void setDepDate(String depDate) {
        this.depDate = depDate == null ? null : depDate.trim();
    }

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime == null ? null : depTime.trim();
    }

    public String getArrDate() {
        return arrDate;
    }

    public void setArrDate(String arrDate) {
        this.arrDate = arrDate == null ? null : arrDate.trim();
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime == null ? null : arrTime.trim();
    }

    public String getStopAirport() {
        return stopAirport;
    }

    public void setStopAirport(String stopAirport) {
        this.stopAirport = stopAirport == null ? null : stopAirport.trim();
    }

    public Integer getMeal() {
        return meal;
    }

    public void setMeal(Integer meal) {
        this.meal = meal;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getPunctuality() {
        return punctuality;
    }

    public void setPunctuality(Integer punctuality) {
        this.punctuality = punctuality;
    }
}