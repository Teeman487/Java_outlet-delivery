package com.java_outletdelivery.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {
    private Long id;
    @NotEmpty(message = "Enter an establishment name")
    private String name;
    @NotEmpty(message = "Enter the address")
    private String address;
    @NotEmpty(message = "Select an establishment type")
    private String typeOfEstablishment;
    @NotEmpty(message = "Enter establishment email")
    @Email
    private String email;
    @NotEmpty(message = "Enter establishment phone contact")
    private String phone;
    @NotEmpty(message = "Enter Strong password")
    private String password;
}

