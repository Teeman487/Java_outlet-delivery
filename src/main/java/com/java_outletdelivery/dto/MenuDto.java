package com.java_outletdelivery.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto {
    private Long id;
    @NotEmpty(message="Enter product name")
    private String name;
    @NotNull(message = "Enter your stock in (e.g. 100)")
    private Long stock;
    @NotNull(message = "Enter your product price (e.g. 1000.0)")
    private Double price;
    @NotEmpty(message="Enter menu description")
    private String description;
    private LocalDateTime createdOn;
    private LocalDateTime updateOn;
}
