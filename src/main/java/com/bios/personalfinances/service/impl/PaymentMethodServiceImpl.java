package com.bios.personalfinances.service.impl;

import com.bios.personalfinances.model.dto.PaymentMethodDTO;
import com.bios.personalfinances.model.entity.PaymentMethod;
import com.bios.personalfinances.repository.PaymentMethodRepository;
import com.bios.personalfinances.service.PaymentMethodService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PaymentMethodDTO findByName(String name) {
        PaymentMethod byMethod = paymentMethodRepository.findByName(name);
        return byMethod != null? modelMapper.map(byMethod, PaymentMethodDTO.class) : null;
    }

    @Override
    public List<PaymentMethodDTO> findByNameStartsWith(String name) {
        List<PaymentMethod> methods = paymentMethodRepository.findByNameStartsWith(name);
        return methods.isEmpty()? null: modelMapper.map(methods, new TypeToken<List<PaymentMethodDTO>>() {
        }.getType());
    }
}
