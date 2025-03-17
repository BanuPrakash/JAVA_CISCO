package com.cisco.prj.entity;

// Specialization
// Mobile IS A Product
public class Mobile extends Product{
    private String connectivity;

    public Mobile() {
    }

    public Mobile(int id, String name, double price, String connectivity) {
        super(id, name, price); // way to invoke base class constructor Product(...)
        this.connectivity = connectivity;
    }

    public String getConnectivity() {
        return connectivity;
    }

    public void setConnectivity(String connectivity) {
        this.connectivity = connectivity;
    }

    @Override
    public boolean isExpensive() {
       if("3G".equals(connectivity) && getPrice()> 4000) {
           return  true;
       } else if ("4G".equals(connectivity) && getPrice() > 12000) {
           return  true;
       } else if("5G".equals(connectivity) && getPrice() > 35000) {
           return true;
       }
       return  false;
    }
}
