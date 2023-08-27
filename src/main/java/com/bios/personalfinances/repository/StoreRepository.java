package com.bios.personalfinances.repository;

import com.bios.personalfinances.model.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
    public Store findByName(String name);
}
