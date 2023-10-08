package com.bios.personalfinances.repository;

import com.bios.personalfinances.model.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
    PaymentMethod findByName(String name);

    List<PaymentMethod> findByNameStartsWith(String name);

}
