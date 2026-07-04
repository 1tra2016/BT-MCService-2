package com.example.demo.service;

import com.example.demo.dto.Product.ProductResponseDTO;

public interface IProductService {
    ProductResponseDTO getProduct(Long id);
}