package com.bios.personalfinances.controller;

import com.bios.personalfinances.model.dto.StoreDTO;
import com.bios.personalfinances.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/findByName/{name}")
    public ResponseEntity<StoreDTO> findByName(@PathVariable("name") String name){
        return ResponseEntity.ok(storeService.findByName(name));
    }
}
