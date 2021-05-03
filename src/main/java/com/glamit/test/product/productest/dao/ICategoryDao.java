package com.glamit.test.product.productest.dao;

import com.glamit.test.product.productest.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryDao extends JpaRepository<Category, Long> {

}
