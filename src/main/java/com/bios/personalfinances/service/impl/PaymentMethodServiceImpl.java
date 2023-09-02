package com.bios.personalfinances.service.impl;

import com.bios.personalfinances.model.entity.PaymentMethod;
import com.bios.personalfinances.model.entity.dto.PaymentMethodDTO;
import com.bios.personalfinances.repository.PaymentMethodRepository;
import com.bios.personalfinances.service.PaymentMethodService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PaymentMethodDTO findByMethod(String method) {
        PaymentMethod byMethod = paymentMethodRepository.findByMethod(method);
        return byMethod != null? modelMapper.map(byMethod, PaymentMethodDTO.class) : null;
    }
}
