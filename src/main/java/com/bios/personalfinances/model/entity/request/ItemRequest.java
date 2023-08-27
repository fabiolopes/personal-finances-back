package com.bios.personalfinances.model.entity.request;

import java.math.BigDecimal;

public record ItemRequest(BigDecimal qtd, BigDecimal valuePaid, Long productDataId) {}
