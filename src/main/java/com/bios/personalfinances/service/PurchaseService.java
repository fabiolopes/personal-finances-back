package com.bios.personalfinances.service;

import com.bios.personalfinances.model.dto.NewPurchaseDTO;
import com.bios.personalfinances.model.dto.PurchaseItemDTO;
import com.bios.personalfinances.model.request.PurchaseRequest;

import java.util.List;

public interface PurchaseService {
    NewPurchaseDTO newPurchase(PurchaseRequest purchaseRequest);

    List<PurchaseItemDTO> getPurchaseList();
}
