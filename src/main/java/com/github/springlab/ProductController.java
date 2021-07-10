package com.github.springlab;

import com.github.springlab.dto.ProductRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ProductController {

    @PostMapping("api/product")
    public ProductRequest registerProduct(@RequestBody @Valid ProductRequest productRequest) {
        return productRequest;
    }
}
