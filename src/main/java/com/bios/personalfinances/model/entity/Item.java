package com.bios.personalfinances.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id @GeneratedValue
    private Long id;
    @OneToOne
    private ProductData productData;
    private BigDecimal qtd;
    private Instant date;
    private BigDecimal valuePaid;
}
