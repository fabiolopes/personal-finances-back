package com.bios.personalfinances.model.request;

import java.math.BigDecimal;

public record ItemRequest(BigDecimal qtd, BigDecimal valuePaid, Long productDataId) {}
