package com.bios.personalfinances.service;

import com.bios.personalfinances.model.dto.ProductDTO;

public interface ProductService {
    ProductDTO findByName(String name);
}
