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
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Item> items;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private PaymentMethod paymentMethod;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Store store;
    private BigDecimal total;
}
