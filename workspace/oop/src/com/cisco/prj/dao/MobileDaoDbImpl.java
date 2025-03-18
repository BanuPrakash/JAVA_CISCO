package com.cisco.prj.dao;

import com.cisco.prj.entity.Mobile;

// realization
public class MobileDaoDbImpl implements MobileDao{
    @Override
    public void addMobile(Mobile mobile) {
        // Actual SQL has to be written ...
        System.out.println(mobile.getName() + " stored in database !!!");
    }
}
