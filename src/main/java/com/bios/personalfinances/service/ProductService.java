package com.bios.personalfinances.service;

import com.bios.personalfinances.model.entity.Product;

public interface ProductService {
    Product findByName(String name);
}
