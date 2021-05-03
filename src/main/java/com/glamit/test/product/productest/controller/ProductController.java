package com.glamit.test.product.productest.controller;

import com.glamit.test.product.productest.dto.ProductDtoRequest;
import com.glamit.test.product.productest.dto.ProductDtoResponse;
import com.glamit.test.product.productest.entity.Product;
import com.glamit.test.product.productest.service.IProductService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;

@Controller
@RequestMapping("/product")
@Api(tags = "Product Controller", value = "Operations for Product Controller")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping()
    @ApiOperation(nickname = "getProductBySku", value = "Get a product by Sku ID", notes = "Allow get a product find by Sku ID or get the product list by default.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Sucessful", response = ResponseEntity.class) })
    public @ResponseBody ResponseEntity<?> getProductBySku( @ApiParam(value = "Unique number ID of product.", defaultValue = "")
                                                            @RequestParam(value = "sku", defaultValue = "") String sku,
                                                            @ApiParam(value = "Position on pageable structure.", defaultValue = "")
                                                            @RequestParam("page") int page) {
        if(sku.length() > 0){
            ProductDtoResponse product = productService.getProduct(sku.trim());

            if(Objects.isNull(product)){
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(product, HttpStatus.OK);

        } else {

            Page<ProductDtoResponse> productList = productService.getProductList(PageRequest.of(page, 3));

            if(Objects.isNull(productList)){
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }
    }

    @PostMapping("create")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, paramType = "header", example = "Bearer R2xhbWl0VXNlclNpZ24=")
    @ApiOperation(nickname = "setProduct", value = "Set a new product", notes = "Allow create a new product in the DB.")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = ResponseEntity.class) })
    public @ResponseBody ResponseEntity<?> setProduct(@ApiParam(value = "Product Request body.") @RequestBody ProductDtoRequest request) {
        Product newProduct = productService.setProduct(request);
        if(Objects.isNull(newProduct)){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }
}
