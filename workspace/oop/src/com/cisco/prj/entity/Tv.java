package com.cisco.prj.entity;

public class Tv extends Product{
    private String screenType;

    public Tv() {
    }

    public Tv(int id, String name, double price, String screenType) {
        super(id, name, price);
        this.screenType = screenType;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    @Override
    public boolean isExpensive() {
        if("CRT".equals(screenType) && getPrice()> 4000) {
            return  true;
        } else if ("4HDR".equals(screenType) && getPrice() > 50_000) {
            return  true;
        } else if("OLED".equals(screenType) && getPrice() > 1_50_000) {
            return true;
        }
        return  false;
    }
}
