package com.example.client.create;

import com.example.client.Product;
import com.example.client.ProductService;
import com.example.client.RetrofitServiceGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/productCreate.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Name = req.getParameter("Name");
        int Price = Integer.parseInt(req.getParameter("Price"));
        ProductService productService = RetrofitServiceGenerator.createService(ProductService.class);
        productService.add(new Product(Name,Price)).execute();
        resp.sendRedirect("/List");

    }
}
