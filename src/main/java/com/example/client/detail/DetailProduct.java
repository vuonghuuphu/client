package com.example.client.detail;

import com.example.client.Product;
import com.example.client.ProductService;
import com.example.client.RetrofitServiceGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DetailProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ProductService productService = RetrofitServiceGenerator.createService(ProductService.class);
        Product p = productService.detail(id).execute().body();
        req.setAttribute("detail",p);
        req.getRequestDispatcher("productdetail.jsp").forward(req,resp);

    }
}
