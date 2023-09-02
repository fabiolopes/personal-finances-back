package com.bios.personalfinances.model.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO{
    private Long id;
    private String name;
    private String description;
    private String unit;
}