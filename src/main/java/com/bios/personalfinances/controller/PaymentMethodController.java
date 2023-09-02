package com.bios.personalfinances.controller;

import com.bios.personalfinances.model.entity.PaymentMethod;
import com.bios.personalfinances.model.entity.Store;
import com.bios.personalfinances.model.entity.dto.PaymentMethodDTO;
import com.bios.personalfinances.repository.PaymentMethodRepository;
import com.bios.personalfinances.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("paymentMethod")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping("/findByMethod/{method}")
    public ResponseEntity<PaymentMethodDTO> findByMethod(@PathVariable("method") String method){
        return ResponseEntity.ok(paymentMethodService.findByMethod(method));
    }

}
