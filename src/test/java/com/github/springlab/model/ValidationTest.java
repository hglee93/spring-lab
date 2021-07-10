package com.github.springlab.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public class ValidationTest {

    private static final Logger log = LoggerFactory.getLogger(ValidationTest.class);

    @Test
    void validateProduct() {
        // Product 객체 생성
        Product product = new Product(0, "화장품", 13000, BigDecimal.valueOf(5.5),
                LocalDateTime.now().plusDays(5),
                LocalDateTime.now().plusDays(10),
                LocalDate.now().minusMonths(3));

        // 예외로 바로 처리할 수도 있습니다.
        // throw new ConstraintViolationException(validate);
    }

    @Test
    @DisplayName("Product 클래스의 Validation 함수 사용")
    void validateProductUsingMethod() {
        // Product 객체 생성
        Product product = new Product(0, "화장품", 13000, BigDecimal.valueOf(5.5),
                LocalDateTime.now().plusDays(5),
                LocalDateTime.now().minusMonths(10),
                LocalDate.now().minusMonths(3));

        // Validator 생성
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        // validation 및 출력
        Set<ConstraintViolation<Product>> validate = validator.validate(product);
        validate.forEach(System.out::println);

        // Product 클래스의 validation 함수 사용
        log.info(String.valueOf(product.isValidSalesPeriod()));
    }
}
