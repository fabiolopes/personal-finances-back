package com.bios.personalfinances.service.impl;

import com.bios.personalfinances.model.dto.CategoryDTO;
import com.bios.personalfinances.model.entity.Category;
import com.bios.personalfinances.repository.CategoryRepository;
import com.bios.personalfinances.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("unused")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDTO findByName(String name) {
        Category category = categoryRepository.findByName(name);
        return category != null? modelMapper.map(category, CategoryDTO.class) : null;
    }

    @Override
    public List<CategoryDTO> findByNameStartsWith(String name) {
        List<Category> categories = categoryRepository.findByNameStartsWith(name);
        return categories.isEmpty()? null: modelMapper.map(categories, new TypeToken<List<CategoryDTO>>() {
        }.getType());
    }
}
