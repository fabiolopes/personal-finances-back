package com.bios.personalfinances.service;

import com.bios.personalfinances.model.entity.PaymentMethod;

public interface PaymentMethodService {
    PaymentMethod findByMethod(String method);
}
