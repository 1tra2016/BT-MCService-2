package com.example.demo.controller;

import com.example.demo.dto.Product.ProductResponseDTO;
import com.example.demo.dto.response.ApiResponse;
import com.example.demo.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final IProductService service;

    public ProductController(IProductService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponseDTO>> getProduct(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(ApiResponse.success(
                200,
                service.getProduct(id)
        ));
    }

}