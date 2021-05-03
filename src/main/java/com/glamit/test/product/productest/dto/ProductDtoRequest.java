package com.glamit.test.product.productest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDtoRequest {
    private String name;
    private Long category;
    private Double price;
    private String imgUrl;
    private String sku;

    public ProductDtoRequest() {}
}
