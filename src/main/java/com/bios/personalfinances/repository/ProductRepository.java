package com.bios.personalfinances.repository;

import com.bios.personalfinances.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);

    List<Product> findByNameStartsWith(String name);
}
