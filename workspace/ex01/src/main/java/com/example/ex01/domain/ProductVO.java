package com.example.ex01.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ProductVO {
    private String productName;
    private Long productPrice;
    private Long productStock;
    private String productBrand;
}
