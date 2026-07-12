package com.example.user.controller;

import com.example.user.dto.apiresponse.ApiResponse;
import com.example.user.dto.user.CustomerCreateDTO;
import com.example.user.dto.user.CustomerLoginDTO;
import com.example.user.dto.user.CustomerResponseDTO;
import com.example.user.entity.Customer;
import com.example.user.service.ICustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<CustomerResponseDTO>> register(
            @Valid @RequestBody CustomerCreateDTO request
    ) {
        return ResponseEntity.ok(ApiResponse.success(
                201,
                customerService.register(request),
                "Register successfully"
        ));
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<CustomerResponseDTO>>> getAllCustomer() {
        return ResponseEntity.ok(ApiResponse.success(
                200,
                customerService.getAll(),
                "Success"
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerResponseDTO>> getCustomer(
            @PathVariable Long id) {

        return ResponseEntity.ok(ApiResponse.success(
                200,
                customerService.getCustomerById(id),
                "Success"
        ));
    }

    @PutMapping("/login")
    public ResponseEntity<ApiResponse<CustomerResponseDTO>> login(
            @Valid @RequestBody CustomerLoginDTO request
    ) {
        return ResponseEntity.ok(ApiResponse.success(
                200,
                customerService.login(request),
                "Login successfully"
        ));
    }
}
