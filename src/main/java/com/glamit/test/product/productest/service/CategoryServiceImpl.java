package com.glamit.test.product.productest.service;

import com.glamit.test.product.productest.dao.ICategoryDao;
import com.glamit.test.product.productest.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    ICategoryDao categoryDao;

    public Category getCategory(Long id) {
        return categoryDao.findById(id).get();
    }

    public List<Category> getCategoryList() {
        List<Category> categories = categoryDao.findAll();
        return categories;
    }
}
