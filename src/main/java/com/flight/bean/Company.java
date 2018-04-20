package com.flight.bean;

public class Company {
    private Integer id;

    private String name;

    private String code;

    private String threeCode;

    private String ticketPre;

    private String englishName;

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

    public String getThreeCode() {
        return threeCode;
    }

    public void setThreeCode(String threeCode) {
        this.threeCode = threeCode == null ? null : threeCode.trim();
    }

    public String getTicketPre() {
        return ticketPre;
    }

    public void setTicketPre(String ticketPre) {
        this.ticketPre = ticketPre == null ? null : ticketPre.trim();
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName == null ? null : englishName.trim();
    }
}