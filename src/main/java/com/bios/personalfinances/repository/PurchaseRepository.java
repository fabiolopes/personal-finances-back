package com.bios.personalfinances.repository;

import com.bios.personalfinances.model.entity.Purchase;
import com.bios.personalfinances.model.entity.ResultPurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Query(value = " SELECT p.date,c.name as category, s.name AS store, pm.method AS paymentMethod, p.total " +
            " FROM purchase p " +
            " LEFT JOIN store s ON s.id = p.store_id " +
            " LEFT JOIN category c ON c.id = p.category_id " +
            " LEFT JOIN payment_method pm ON pm.id = p.payment_method_id order by p.date DESC", nativeQuery = true)
    List<ResultPurchaseItem> getPurchaseList();
}
