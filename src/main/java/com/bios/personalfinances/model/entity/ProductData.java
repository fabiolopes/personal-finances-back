package com.bios.personalfinances.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductData {
    @Id @GeneratedValue
    private Long id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Product product;
    private LocalDate referenceDate;
    private BigDecimal price;
}
