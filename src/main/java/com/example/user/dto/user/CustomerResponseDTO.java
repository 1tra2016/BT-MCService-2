package com.example.user.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponseDTO {
    private Long id;
    private String fullName;
    private String email;
}