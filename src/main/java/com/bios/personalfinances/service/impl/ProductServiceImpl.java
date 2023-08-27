package com.bios.personalfinances.service.impl;

import com.bios.personalfinances.model.entity.Product;
import com.bios.personalfinances.repository.ProductRepository;
import com.bios.personalfinances.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }
}
