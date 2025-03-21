package com.cisco.prj.dao;

import com.cisco.prj.entity.Product;

import java.util.List;

public interface ProductDao {
    public void addProduct(Product product) throws PersistenceException;
    public List<Product> getProducts() throws FetchException;
}
