package com.bios.personalfinances.service;

import com.bios.personalfinances.model.entity.dto.NewPurchaseDTO;
import com.bios.personalfinances.model.entity.request.PurchaseRequest;

public interface PurchaseService {
    NewPurchaseDTO newPurchase(PurchaseRequest purchaseRequest);
}
