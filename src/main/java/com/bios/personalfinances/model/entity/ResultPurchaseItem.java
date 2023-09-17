package com.bios.personalfinances.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ResultPurchaseItem {
    LocalDate getDate();

    String getCategory();
    String getStore();
    String getPaymentMethod();
    BigDecimal getTotal();
}
