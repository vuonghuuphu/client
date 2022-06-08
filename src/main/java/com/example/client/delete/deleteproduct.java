package com.example.client.delete;

import com.example.client.Product;
import com.example.client.ProductService;
import com.example.client.RetrofitServiceGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deleteproduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ProductService productService = RetrofitServiceGenerator.createService(ProductService.class);
         productService.delete(id).execute().body();
            resp.sendRedirect("/List");


    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
//        Product obj = null;
//        try {
//            obj = model.findbyId(id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        if (obj == null){
//            resp.setStatus(404);
//            resp.getWriter().println("Not found");
//        }else{
//            model.delete(id);
//            resp.sendRedirect("/AssignmentJSPServlet_war_exploded/admin/listproducts");
//        }
//    }
}
