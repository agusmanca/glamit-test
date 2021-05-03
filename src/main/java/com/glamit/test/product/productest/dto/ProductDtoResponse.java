package com.glamit.test.product.productest.dto;

import com.glamit.test.product.productest.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDtoResponse {
    private Long id;
    private String name;
    private Category category;
    private Double price;
    private String imgUrl;
    private String sku;

    public ProductDtoResponse() {}
}
