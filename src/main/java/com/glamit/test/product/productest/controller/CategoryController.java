package com.glamit.test.product.productest.controller;

import com.glamit.test.product.productest.entity.Category;
import com.glamit.test.product.productest.service.ICategoryService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/category")
@Api(tags = "Category Controller", value = "Operations for Category Controller")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = "/{id}")
    @ApiOperation(nickname = "getCategoryById", value = "Get a category by ID", notes = "Allow get a category find by ID.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Sucessful", response = ResponseEntity.class) })
    public ResponseEntity<Category> getCategory(@ApiParam(value = "Unique number ID of category.") @PathVariable("id") Long id) {
        Category category = categoryService.getCategory(id);

        if(Objects.isNull(category)){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Category>> getCategoryList() {
        List<Category> categories = categoryService.getCategoryList();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
