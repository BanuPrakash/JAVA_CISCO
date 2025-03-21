package com.cisco.prj.dao;

import com.cisco.prj.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class ProductDaoJdbcImpl implements ProductDao {


    @Override
    public void addProduct(Product product) throws PersistenceException {
        String SQL = "insert into products (id, name, price) values (0, ?, ?)";
        Connection con = null;

        try {
            con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.executeUpdate(); // insert, delete or update SQL
        } catch (SQLException e) {
            throw new PersistenceException("unable to add product!!!", e);
        } finally {
            DBUtil.closeConnection(con);
//            if(con != null) {
//                try {
//                    con.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
        }
        }

    @Override
    public List<Product> getProducts() throws FetchException {
        List<Product> products = new ArrayList<>();
        String SQL = "select id, name, price from products";
        Connection con = null;

        try {
            con = DBUtil.getConnection();
            //DriverManager.getConnection("jdbc:mysql://localhost:3306/JAVA_CISCO_DB", "root", "Welcome123");
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                products.add(new Product(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("price")));
            }
        } catch (SQLException e) {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", Locale.FRENCH);
            throw new FetchException(resourceBundle.getString("PRODUCT_ADDED"), e);
        } finally {
            DBUtil.closeConnection(con);
//            if(con != null) {
//                try {
//                    con.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
        }

        return products;
    }
}
