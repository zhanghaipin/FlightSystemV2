package com.flight.bean;

public class Airport {
    private Integer id;

    private String name;

    private String code;

    private String fourCode;

    private String belongCity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getFourCode() {
        return fourCode;
    }

    public void setFourCode(String fourCode) {
        this.fourCode = fourCode == null ? null : fourCode.trim();
    }

    public String getBelongCity() {
        return belongCity;
    }

    public void setBelongCity(String belongCity) {
        this.belongCity = belongCity == null ? null : belongCity.trim();
    }
}