package com.glamit.test.product.productest.dao;

import com.glamit.test.product.productest.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductDao extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.sku = ?1")
    Product findBySku(String sku);
}
