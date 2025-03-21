package com.cisco.prj.client;

import com.cisco.prj.dao.PersistenceException;
import com.cisco.prj.dao.ProductDao;
import com.cisco.prj.dao.ProductDaoJdbcImpl;
import com.cisco.prj.entity.Product;

public class ProductAddClient {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDaoJdbcImpl(); // use factory instead
        Product p = new Product(0, "iPhone 16", 98000.00);

        try {
            productDao.addProduct(p);
            System.out.println("Product added Successfully!!!");
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
        }

    }
}
