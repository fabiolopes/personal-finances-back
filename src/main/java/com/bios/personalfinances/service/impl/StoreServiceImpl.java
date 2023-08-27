package com.bios.personalfinances.service.impl;

import com.bios.personalfinances.model.entity.Store;
import com.bios.personalfinances.repository.StoreRepository;
import com.bios.personalfinances.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Store findByName(String name) {
        return storeRepository.findByName(name);
    }
}
