package com.bios.personalfinances.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Entity
@Data
@Builder
public class Purchase {
    @Id @GeneratedValue
    private Long id;
    private Instant date;
    @OneToMany
    private List<Item> items;
    @ManyToOne
    private PaymentMethod paymentMethod;
    @ManyToOne
    private Store store;
    @ManyToOne
    private Category category;
    private BigDecimal total;
}
