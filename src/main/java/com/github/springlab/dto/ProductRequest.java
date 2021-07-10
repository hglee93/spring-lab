package com.github.springlab.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
public class ProductRequest {

    @Positive
    private final long productNo;

    @NotNull
    private final String name;

    public ProductRequest(long productNo, String name) {
        this.productNo = productNo;
        this.name = name;
    }
}
