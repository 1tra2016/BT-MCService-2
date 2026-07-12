package com.example.user.mapper;

import com.example.user.dto.user.CustomerCreateDTO;
import com.example.user.dto.user.CustomerResponseDTO;
import com.example.user.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toEntity(CustomerCreateDTO dto);
    CustomerResponseDTO toResponse(Customer user);
}