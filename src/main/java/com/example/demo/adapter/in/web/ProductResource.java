package com.example.demo.adapter.in.web;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProductResponseDto;
import com.example.demo.application.port.in.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductResource {

    private final ProductService productService;

    @Autowired
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    /**
     * 제품 생성
     *
     * @return
     */
    @PostMapping(value = "/product")
    public ProductResponseDto createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }


    /**
     * 제품 조회
     *
     * @return
     */
    @GetMapping(value = "/product/{id}")
    public ProductResponseDto getProduct(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }

    /**
     * 제품 삭제
     *
     * @return
     */
    @DeleteMapping(value = "/product/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

    /**
     * 제품 수정
     *
     * @return
     */
    @PutMapping(value = "/product/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable("id") Long id,
                                                            @RequestBody ProductDto productDto) {
        ProductResponseDto productResponseDto = productService.updateProduct(id, productDto);
        return ResponseEntity.status(200).body(productResponseDto);
    }


}
