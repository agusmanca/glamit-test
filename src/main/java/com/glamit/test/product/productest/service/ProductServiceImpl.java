package com.glamit.test.product.productest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.glamit.test.product.productest.dao.ICategoryDao;
import com.glamit.test.product.productest.dao.IProductDao;
import com.glamit.test.product.productest.dto.ProductDtoRequest;
import com.glamit.test.product.productest.dto.ProductDtoResponse;
import com.glamit.test.product.productest.entity.Category;
import com.glamit.test.product.productest.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductDao productDao;

    @Autowired
    ICategoryDao categoryDao;

    @Transactional(readOnly = true)
    public Page<ProductDtoResponse> getProductList(Pageable pageable) {
        ModelMapper modelMapper = new ModelMapper();

        Page<Product> productList = productDao.findAll(pageable);
        Page<ProductDtoResponse> productListPage = productList.map(p -> modelMapper.map(p, ProductDtoResponse.class));

        productListPage.getContent().forEach(plp -> {
            Product product = productList.getContent().stream().filter(c -> c.getId() == plp.getId()).findAny().get();
            Category category = null;

            if(categoryDao.findById(product.getCategory()).isPresent()){
                category = categoryDao.findById(product.getCategory()).get();
            }
            plp.setCategory(category);
        });

        return productListPage;
    }

    @Transactional(readOnly = true)
    public ProductDtoResponse getProduct(String sku) {
        ModelMapper modelMapper = new ModelMapper();
        Product product = productDao.findBySku(sku);
        ProductDtoResponse productResponse = modelMapper.map(product, ProductDtoResponse.class);
        Category category =  categoryDao.findById(productResponse.getId()).get();
        productResponse.setCategory(category);

        return productResponse;
    }

    @Transactional()
    public Product setProduct(ProductDtoRequest request) {
        ModelMapper modelMapper = new ModelMapper();
        Product newProduct = productDao.save(modelMapper.map(request, Product.class));

        if(Objects.isNull(newProduct)){
            return null;
        }
        return newProduct;
    }
}
