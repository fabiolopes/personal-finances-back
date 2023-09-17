package com.bios.personalfinances.controller;

import com.bios.personalfinances.model.dto.NewPurchaseDTO;
import com.bios.personalfinances.model.dto.PurchaseItemDTO;
import com.bios.personalfinances.model.request.PurchaseRequest;
import com.bios.personalfinances.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<NewPurchaseDTO> create(@RequestBody PurchaseRequest request) {
        return new ResponseEntity(purchaseService.newPurchase(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PurchaseItemDTO>> getPurchaseList(){
        return ResponseEntity.ok(purchaseService.getPurchaseList());
    }
}
