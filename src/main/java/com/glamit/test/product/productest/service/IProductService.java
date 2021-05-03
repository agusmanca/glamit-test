package com.glamit.test.product.productest.service;

import com.glamit.test.product.productest.dto.ProductDtoRequest;
import com.glamit.test.product.productest.dto.ProductDtoResponse;
import com.glamit.test.product.productest.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    ProductDtoResponse getProduct(String sku);
    Page<ProductDtoResponse> getProductList(Pageable pageable);
    Product setProduct(ProductDtoRequest request);
}
