package com.bios.personalfinances.service;

import com.bios.personalfinances.model.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO findByName(String name);

    List<CategoryDTO> findByNameStartsWith(String name);
}
