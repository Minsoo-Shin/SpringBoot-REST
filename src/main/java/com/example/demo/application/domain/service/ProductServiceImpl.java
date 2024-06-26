package com.example.demo.application.domain.service;

import com.example.demo.application.port.in.ProductService;
import com.example.demo.application.domain.entity.Product;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProductResponseDto;
import com.example.demo.adapter.out.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDto createProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());

        Product save = productRepository.save(product);

        return new ProductResponseDto().from(save);
    }

    public ProductResponseDto getProduct(Long id) {
        Optional<Product> findProduct = productRepository.findById(id);

        if (!findProduct.isPresent()){
            return null;
        }

        Product product = findProduct.get();

        return new ProductResponseDto().from(product);

    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public ProductResponseDto updateProduct(Long id, ProductDto productDto) {
        Optional<Product> findProduct = productRepository.findById(id);

        if (!findProduct.isPresent()){
            return null;
        }

        Product product = findProduct.get();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());

        Product save = productRepository.save(product);

        return new ProductResponseDto().from(save);
    }

    public List<ProductResponseDto> listProducts(double minPrice, double maxPrice) {
        List<Product> products = productRepository.findByPriceGreaterThanEqualAndPriceLessThanEqualOrderByIdDesc(minPrice, maxPrice);

        return new ProductResponseDto().from(products);
    }
}
