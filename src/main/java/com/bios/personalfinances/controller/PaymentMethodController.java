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

    @GetMapping("/findByName/{name}")
    public ResponseEntity<PaymentMethodDTO> findByName(@PathVariable("name") String name){
        return ResponseEntity.ok(paymentMethodService.findByName(name));
    }

    @GetMapping("/findByNameStartsWith/{name}")
    public ResponseEntity<List<PaymentMethodDTO>> findByNameStartsWith(@PathVariable("name") String name){
        return ResponseEntity.ok(paymentMethodService.findByNameStartsWith(name));
    }

}
