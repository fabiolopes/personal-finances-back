package com.bios.personalfinances.service.impl;

import com.bios.personalfinances.model.entity.PaymentMethod;
import com.bios.personalfinances.model.entity.Product;
import com.bios.personalfinances.model.dto.ProductDTO;
import com.bios.personalfinances.repository.ProductRepository;
import com.bios.personalfinances.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<ProductDTO> findByNameStartsWith(String name) {
        List<Product> products = productRepository.findByNameStartsWith(name);
        return products.isEmpty()? null: modelMapper.map(products, new TypeToken<List<ProductDTO>>() {
        }.getType());
    }
}
