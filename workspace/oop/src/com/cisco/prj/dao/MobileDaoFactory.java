package com.cisco.prj.dao;

import java.util.ResourceBundle;

public class MobileDaoFactory {
    private  static  String CLASS_NAME = "";
    // blocks gets called as soon as the class is loaded,
    // no need to explicitly call them
    // loading drivers, reading configurations should be done
    // in static blocks
    static  {
        ResourceBundle res = ResourceBundle.getBundle("config");
        CLASS_NAME = res.getString("MOBILE_DAO");
    }

    public static  MobileDao getMobileDao() {
        // return new MobileDaoMongoImpl();
        try {
               return (MobileDao) Class.forName(CLASS_NAME).getConstructor().newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return  null;
    }
}
