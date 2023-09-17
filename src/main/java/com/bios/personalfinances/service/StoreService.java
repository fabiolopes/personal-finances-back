package com.bios.personalfinances.service;

import com.bios.personalfinances.model.dto.StoreDTO;

public interface StoreService {
    StoreDTO findByName(String name);
}
