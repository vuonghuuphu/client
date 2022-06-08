package com.example.client;

import org.junit.jupiter.api.Test;

import javax.xml.ws.Service;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ProductServiceTest {
    @Test
    public void list() throws IOException {
        ProductService productService = RetrofitServiceGenerator.createService(ProductService.class);
//        List<Product> products = productService.getlist().execute().body();
//        for (Product pro : products){
//            System.out.println(pro.toString());
//        }
        productService.add(new Product("Hello", 2));
    }
}