package com.bios.personalfinances.service.impl;

import com.bios.personalfinances.model.entity.Store;
import com.bios.personalfinances.model.dto.StoreDTO;
import com.bios.personalfinances.repository.StoreRepository;
import com.bios.personalfinances.service.StoreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StoreDTO findByName(String name) {
        Store store = storeRepository.findByName(name);
        return store != null? modelMapper.map(store, StoreDTO.class) : null;
    }
}
