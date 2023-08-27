package com.bios.personalfinances.service;

import com.bios.personalfinances.model.entity.Store;

public interface StoreService {
    Store findByName(String name);
}
