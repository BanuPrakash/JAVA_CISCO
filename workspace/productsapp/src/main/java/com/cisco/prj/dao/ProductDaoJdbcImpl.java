package com.cisco.prj.dao;

import com.cisco.prj.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoJdbcImpl implements ProductDao {
    // load drivers of database
    static  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addProduct(Product product) throws PersistenceException {
        String SQL = "insert into products (id, name, price) values (0, ?, ?)";
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JAVA_CISCO_DB", "root", "Welcome123");
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.executeUpdate(); // insert, delete or update SQL
        } catch (SQLException e) {
            throw new PersistenceException("unable to add product!!!");
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        }

    @Override
    public List<Product> getProducts() throws FetchException {
        List<Product> products = new ArrayList<>();
        String SQL = "select id, name, price from products";
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JAVA_CISCO_DB", "root", "Welcome123");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                products.add(new Product(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("price")));
            }
        } catch (SQLException e) {
            throw new FetchException("unable to get products!!!");
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return products;
    }
}
