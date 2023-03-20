package com.example.ex03.controller;


import com.example.ex03.domain.vo.ProductVO;
import com.example.ex03.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @PostMapping("/product/register")
    public String register(ProductVO productVO){
        productService.registerProduct(productVO);
        return "등록 완료";
    }

    @PutMapping("/product/update")
    public String updateProductVO(ProductVO productVO){
        productService.updateProduct(productVO);
        return "변경 완료";
    }

    @GetMapping("/product/list")
    public List<ProductVO> getList(){
        List<ProductVO> products = productService.getList();
        return products;
    }

    @GetMapping("/product/product")
    public ProductVO getProduct(Long productId){
        return productService.getProductVO(productId);
    }
}
