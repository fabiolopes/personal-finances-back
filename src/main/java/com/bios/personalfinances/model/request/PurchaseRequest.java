package com.bios.personalfinances.model.request;

import com.bios.personalfinances.model.dto.CategoryDTO;
import com.bios.personalfinances.model.dto.ItemDTO;
import com.bios.personalfinances.model.dto.PaymentMethodDTO;
import com.bios.personalfinances.model.dto.StoreDTO;

import java.math.BigDecimal;
import java.util.List;

public record PurchaseRequest(StoreDTO store, List<ItemDTO> items, PaymentMethodDTO paymentMethod, CategoryDTO category, BigDecimal total) {}
