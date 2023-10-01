package com.bios.personalfinances.service;

import com.bios.personalfinances.model.dto.PaymentMethodDTO;

import java.util.List;

public interface PaymentMethodService {
    PaymentMethodDTO findByMethod(String method);

    List<PaymentMethodDTO> findByMethodStartsWith(String method);
}
