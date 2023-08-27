package com.bios.personalfinances.repository;

import com.bios.personalfinances.model.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
