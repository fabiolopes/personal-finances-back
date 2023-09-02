package com.bios.personalfinances.service;

import com.bios.personalfinances.model.entity.dto.ProductDTO;

public interface ProductService {
    ProductDTO findByName(String name);
}
