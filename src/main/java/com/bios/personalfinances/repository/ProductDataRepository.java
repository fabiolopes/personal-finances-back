package com.bios.personalfinances.repository;

import com.bios.personalfinances.model.entity.ProductData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDataRepository extends JpaRepository<ProductData, Long> {
}
