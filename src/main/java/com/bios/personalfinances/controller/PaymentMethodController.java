package com.bios.personalfinances.controller;

import com.bios.personalfinances.model.dto.PaymentMethodDTO;
import com.bios.personalfinances.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paymentMethod")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping("/findByMethod/{method}")
    public ResponseEntity<PaymentMethodDTO> findByMethod(@PathVariable("method") String method){
        return ResponseEntity.ok(paymentMethodService.findByMethod(method));
    }

    @GetMapping("/findByMethodStartsWith/{method}")
    public ResponseEntity<List<PaymentMethodDTO>> findByMethodStartsWith(@PathVariable("method") String method){
        return ResponseEntity.ok(paymentMethodService.findByMethodStartsWith(method));
    }

}
