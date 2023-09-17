package com.bios.personalfinances.service;

import com.bios.personalfinances.model.dto.PaymentMethodDTO;

public interface PaymentMethodService {
    PaymentMethodDTO findByMethod(String method);
}
