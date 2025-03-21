package com.cisco.prj.web;

import com.cisco.prj.dao.FetchException;
import com.cisco.prj.dao.ProductDao;
import com.cisco.prj.dao.ProductDaoJdbcImpl;
import com.cisco.prj.entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    // GET http://localhost:8080/products
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter(); // open character stream to client [Browser]
        out.print("<html><body>");
        out.print("<table>");
        out.print("<tr><th>ID</th><th>NAME</th><th>PRICE</th></tr>");
        ProductDao productDao = new ProductDaoJdbcImpl(); // use factory instead

        try {
            List<Product> products = productDao.getProducts();
            for(Product p : products) {
//                System.out.println(p);
                out.print("<tr>");
                    out.print("<td>");
                        out.print(p.getId());
                    out.print("</td>");
                    out.print("<td>");
                         out.print(p.getName());
                    out.print("</td>");
                    out.print("<td>");
                        out.print(p.getPrice());
                    out.print("</td>");
                out.print("</tr>");
            }
        } catch (FetchException e) {
//            System.out.println(e.getMessage()); // end user --> production
            e.printStackTrace(); // development, maintenance stage
        }
        out.print("</table></body></html>");
    }
}
