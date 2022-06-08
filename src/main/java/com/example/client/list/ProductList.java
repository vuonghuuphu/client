package com.example.client.list;

import com.example.client.Product;
import com.example.client.ProductService;
import com.example.client.RetrofitServiceGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = RetrofitServiceGenerator.createService(ProductService.class);
        List<Product> products = productService.getlist().execute().body();
        req.setAttribute("l",products);
        req.getRequestDispatcher("/listProduct.jsp").forward(req,resp);
    }
}
