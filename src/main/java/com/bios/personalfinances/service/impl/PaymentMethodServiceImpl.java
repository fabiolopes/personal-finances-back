package com.bios.personalfinances.service.impl;

import com.bios.personalfinances.model.entity.PaymentMethod;
import com.bios.personalfinances.repository.PaymentMethodRepository;
import com.bios.personalfinances.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Override
    public PaymentMethod findByMethod(String method) {
        return paymentMethodRepository.findByMethod(method);
    }
}
