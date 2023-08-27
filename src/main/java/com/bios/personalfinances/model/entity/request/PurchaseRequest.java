package com.bios.personalfinances.model.entity.request;

import com.bios.personalfinances.model.entity.dto.PaymentMethodDTO;
import com.bios.personalfinances.model.entity.dto.ProductDTO;
import com.bios.personalfinances.model.entity.dto.StoreDTO;

import java.math.BigDecimal;

public record PurchaseRequest(BigDecimal preco, BigDecimal qtd, BigDecimal valorPago, StoreDTO store, ProductDTO product, PaymentMethodDTO paymentMethod) {}
