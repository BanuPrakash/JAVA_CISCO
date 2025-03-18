package com.cisco.prj.dao;

import com.cisco.prj.entity.Mobile;

public class MobileDaoMongoImpl implements MobileDao{
    @Override
    public void addMobile(Mobile mobile) {
        System.out.println("Mongo Store " + mobile.getName());
    }
}
