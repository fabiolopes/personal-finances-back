package com.bios.personalfinances.controller;

import com.bios.personalfinances.model.entity.dto.NewPurchaseDTO;
import com.bios.personalfinances.model.entity.request.PurchaseRequest;
import com.bios.personalfinances.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<NewPurchaseDTO> create(@RequestBody PurchaseRequest request) {
        return new ResponseEntity(purchaseService.newPurchase(request), HttpStatus.CREATED);
    }
}
