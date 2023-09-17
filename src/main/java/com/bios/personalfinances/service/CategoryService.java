package com.bios.personalfinances.service;

import com.bios.personalfinances.model.dto.CategoryDTO;

public interface CategoryService {

    CategoryDTO findByName(String name);
}
