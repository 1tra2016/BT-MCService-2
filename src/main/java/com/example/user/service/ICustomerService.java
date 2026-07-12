package com.example.user.service;

import com.example.user.dto.user.CustomerCreateDTO;
import com.example.user.dto.user.CustomerLoginDTO;
import com.example.user.dto.user.CustomerResponseDTO;
import com.example.user.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<CustomerResponseDTO> getAll();
    CustomerResponseDTO register(CustomerCreateDTO request);
    CustomerResponseDTO getCustomerById(Long id);
    CustomerResponseDTO login(CustomerLoginDTO request);
}
