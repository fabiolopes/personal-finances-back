package com.bios.personalfinances.service;

import com.bios.personalfinances.model.entity.dto.StoreDTO;

public interface StoreService {
    StoreDTO findByName(String name);
}
