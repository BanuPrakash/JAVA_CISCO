package com.cisco.prj.client;

import com.cisco.prj.dao.FetchException;
import com.cisco.prj.dao.ProductDao;
import com.cisco.prj.dao.ProductDaoJdbcImpl;
import com.cisco.prj.entity.Product;

import java.util.List;

public class FetchClient {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDaoJdbcImpl(); // use factory instead

        try {
            List<Product> products = productDao.getProducts();
            for(Product p : products) {
                System.out.println(p);
            }
        } catch (FetchException e) {
//            System.out.println(e.getMessage()); // end user --> production
        e.printStackTrace(); // development, maintenance stage
        }
    }
}
