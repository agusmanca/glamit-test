package com.glamit.test.product.productest.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.glamit.test.product.productest.dao.ICategoryDao;
import com.glamit.test.product.productest.dao.IProductDao;
import com.glamit.test.product.productest.entity.Category;
import com.glamit.test.product.productest.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Configuration
public class BeansConfig {

    @Autowired
    ICategoryDao categoryDao;

    @Autowired
    IProductDao productDao;

    @Bean
    @Qualifier("startDataBase")
    public void startDatabeWithJsonInfo() throws IOException {
        List<Category> categories = getCategoryFromJson();
        List<Product> products = getProductsFromJson();

        categoryDao.saveAll(categories);
        productDao.saveAll(products);
    }

    private List<Product> getProductsFromJson() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("static/product.json").getFile());
        ObjectMapper objectMapper = new ObjectMapper();
        return Arrays.asList(objectMapper.readValue(file, Product[].class));
    }

    private List<Category> getCategoryFromJson() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("static/category.json").getFile());
        ObjectMapper objectMapper = new ObjectMapper();
        return Arrays.asList(objectMapper.readValue(file, Category[].class));
    }
}
