package com.example.user.service.impl;

import com.example.user.dto.user.CustomerCreateDTO;
import com.example.user.dto.user.CustomerLoginDTO;
import com.example.user.dto.user.CustomerResponseDTO;
import com.example.user.entity.Customer;
import com.example.user.exception.exceptions.BadRequestException;
import com.example.user.exception.exceptions.ResourceNotFoundException;
import com.example.user.mapper.CustomerMapper;
import com.example.user.repository.CustomerRepository;
import com.example.user.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements ICustomerService {
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<CustomerResponseDTO> getAll(){
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toResponse)
                .toList();
    }

    @Override
    public CustomerResponseDTO register(CustomerCreateDTO request) {

        Customer customer = customerMapper.toEntity(request);

        customer.setPassword(passwordEncoder.encode(request.getPassword()));

        customer = customerRepository.save(customer);

        return customerMapper.toResponse(customer);
    }

    @Override
    public CustomerResponseDTO getCustomerById(Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found"));

        return customerMapper.toResponse(customer);
    }

    @Override
    public CustomerResponseDTO login(CustomerLoginDTO request) {

        Customer customer = customerRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new BadRequestException("email or password incorrect"));

        if (!passwordEncoder.matches(request.getPassword(), customer.getPassword())) {
            throw new BadRequestException("email or password incorrect");
        }

        return customerMapper.toResponse(customer);
    }

}
