package com.bios.personalfinances.model.entity.dto;

import com.bios.personalfinances.model.entity.Item;
import com.bios.personalfinances.model.entity.PaymentMethod;
import com.bios.personalfinances.model.entity.Store;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class NewPurchaseDTO {
    private Long id;
    private Instant date;
    private List<Item> items;
    private PaymentMethod paymentMethod;
    private Store store;
}
