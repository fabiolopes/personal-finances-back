package com.bios.personalfinances.service;

import com.bios.personalfinances.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO findByName(String name);

    List<ProductDTO> findByNameStartsWith(String name);
}
