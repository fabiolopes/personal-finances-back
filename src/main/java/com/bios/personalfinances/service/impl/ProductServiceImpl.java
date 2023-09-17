package com.bios.personalfinances.service.impl;

import com.bios.personalfinances.model.entity.Product;
import com.bios.personalfinances.model.dto.ProductDTO;
import com.bios.personalfinances.repository.ProductRepository;
import com.bios.personalfinances.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDTO findByName(String name) {
        Product product = productRepository.findByName(name);
        return product != null? modelMapper.map(product, ProductDTO.class) : null;
    }
}
