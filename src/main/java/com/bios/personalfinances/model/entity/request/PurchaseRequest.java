package com.bios.personalfinances.model.entity.request;

import com.bios.personalfinances.model.entity.dto.ItemDTO;
import com.bios.personalfinances.model.entity.dto.PaymentMethodDTO;
import com.bios.personalfinances.model.entity.dto.ProductDTO;
import com.bios.personalfinances.model.entity.dto.StoreDTO;

import java.math.BigDecimal;
import java.util.List;

public record PurchaseRequest(StoreDTO store, List<ItemDTO> items, PaymentMethodDTO paymentMethod, BigDecimal total) {}
