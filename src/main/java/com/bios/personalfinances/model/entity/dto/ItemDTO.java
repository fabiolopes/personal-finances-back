package com.bios.personalfinances.model.entity.dto;

import java.math.BigDecimal;

public record ItemDTO(BigDecimal price, ProductDTO product, BigDecimal qtd, BigDecimal valuePaid) {
}
