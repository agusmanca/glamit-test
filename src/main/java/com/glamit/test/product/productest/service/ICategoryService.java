package com.glamit.test.product.productest.service;

import com.glamit.test.product.productest.entity.Category;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {
    Category getCategory(Long id);
    List<Category> getCategoryList();
}
