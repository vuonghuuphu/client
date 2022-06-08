package com.example.client.edit;

import com.example.client.Product;
import com.example.client.ProductService;
import com.example.client.RetrofitServiceGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UpdateProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ProductService productService = RetrofitServiceGenerator.createService(ProductService.class);
        Product p = productService.detail(id).execute().body();
        req.setAttribute("d", p);
        req.getRequestDispatcher("/productsupdate.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("Id"));
        String Name = req.getParameter("Name");
        int Price = Integer.parseInt(req.getParameter("Price"));
        ProductService productService = RetrofitServiceGenerator.createService(ProductService.class);
        productService.update(id,new Product(id,Name,Price)).execute();
        resp.sendRedirect("/List");
    }
}
