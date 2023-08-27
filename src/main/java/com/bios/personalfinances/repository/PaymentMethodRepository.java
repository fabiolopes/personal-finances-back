package com.bios.personalfinances.repository;

import com.bios.personalfinances.model.entity.PaymentMethod;
import com.bios.personalfinances.model.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
    PaymentMethod findByMethod(String method);
}
