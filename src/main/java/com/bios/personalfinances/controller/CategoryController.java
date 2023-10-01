package com.bios.personalfinances.controller;

import com.bios.personalfinances.model.dto.CategoryDTO;
import com.bios.personalfinances.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/findByName/{name}")
    public ResponseEntity<CategoryDTO> findByName(@PathVariable("name") String name){
        return ResponseEntity.ok(categoryService.findByName(name));
    }

    @GetMapping("/findByNameStartsWith/{name}")
    public ResponseEntity<List<CategoryDTO>> findByNameStartsWith(@PathVariable("name") String name){
        return ResponseEntity.ok(categoryService.findByNameStartsWith(name));
    }
}
