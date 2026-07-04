package com.example.demo.mapper;


import com.example.demo.dto.Product.ProductResponseDTO;
import com.example.demo.entity.Product;

public class ProductMapper {

    public static ProductResponseDTO toResponse(Product entity){

        return new ProductResponseDTO(
                entity.getId(),
                entity.getName(),
                entity.getSellPrice()
        );
    }

}