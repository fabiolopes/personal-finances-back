package com.bios.personalfinances.repository;

import com.bios.personalfinances.model.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    public Store findByName(String name);

    List<Store> findByNameStartsWith(String name);
}
