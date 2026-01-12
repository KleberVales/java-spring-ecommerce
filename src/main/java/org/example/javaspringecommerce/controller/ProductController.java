package org.example.javaspringecommerce.controller;

import jakarta.validation.Valid;
import org.example.javaspringecommerce.domain.product.Product;
import org.example.javaspringecommerce.dto.product.ProductRequestDTO;
import org.example.javaspringecommerce.dto.product.ProductResponseDTO;
import org.example.javaspringecommerce.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public ResponseEntity<ProductResponseDTO> save(@Valid @RequestBody ProductRequestDTO dto) {

        Product product = productService.save(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ProductResponseDTO(product));
    }




}
