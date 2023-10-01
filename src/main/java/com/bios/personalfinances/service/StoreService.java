package com.bios.personalfinances.service;

import com.bios.personalfinances.model.dto.CategoryDTO;
import com.bios.personalfinances.model.dto.StoreDTO;

import java.util.List;

public interface StoreService {
    StoreDTO findByName(String name);

    List<StoreDTO> findByNameStartsWith(String name);
}
