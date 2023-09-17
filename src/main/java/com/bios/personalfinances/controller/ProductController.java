package com.bios.personalfinances.controller;

import com.bios.personalfinances.model.dto.ProductDTO;
import com.bios.personalfinances.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/findByName/{name}")
    public ResponseEntity<ProductDTO> findByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(productService.findByName(name));
    }
}
