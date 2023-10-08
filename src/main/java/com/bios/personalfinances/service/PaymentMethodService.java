package com.bios.personalfinances.service;

import com.bios.personalfinances.model.dto.PaymentMethodDTO;

import java.util.List;

public interface PaymentMethodService {
    PaymentMethodDTO findByName(String name);

    List<PaymentMethodDTO> findByNameStartsWith(String name);
}
