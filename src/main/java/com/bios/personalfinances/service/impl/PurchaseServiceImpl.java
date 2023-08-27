package com.bios.personalfinances.service.impl;

import com.bios.personalfinances.model.entity.*;
import com.bios.personalfinances.model.entity.dto.NewPurchaseDTO;
import com.bios.personalfinances.model.entity.dto.ProductDTO;
import com.bios.personalfinances.model.entity.request.PurchaseRequest;
import com.bios.personalfinances.repository.PurchaseRepository;
import com.bios.personalfinances.service.PaymentMethodService;
import com.bios.personalfinances.service.ProductService;
import com.bios.personalfinances.service.PurchaseService;
import com.bios.personalfinances.service.StoreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Collections;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StoreService storeService;
    @Autowired
    private PaymentMethodService paymentMethodService;

    @Autowired
    private ProductService productService;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public NewPurchaseDTO newPurchase(PurchaseRequest purchaseRequest) {
        Purchase purchase = Purchase.builder().date(Instant.now()).build();
        setStore(purchaseRequest.store().name(), purchase);
        setPaymentMethod(purchaseRequest.paymentMethod().method(), purchase);
        ProductData productData = ProductData.builder().price(purchaseRequest.preco())
                .referenceDate(LocalDate.now()).build();
        setProduct(productData, purchaseRequest.product());
        Item item = Item.builder().valuePaid(purchaseRequest.valorPago()).qtd(purchaseRequest.qtd())
                .date(Instant.now()).productData(productData).build();
        purchase.setItems(Collections.singletonList(item));
        Purchase saved = purchaseRepository.save(purchase);
        return modelMapper.map(saved, NewPurchaseDTO.class);
    }

    private void setPaymentMethod(String method, Purchase purchase) {
        PaymentMethod paymentMethod = paymentMethodService.findByMethod(method);
        if(paymentMethod == null){
            paymentMethod = PaymentMethod.builder().method(method).build();
        }
        purchase.setPaymentMethod(paymentMethod);
    }

    private void setStore(String storeName, Purchase purchase){
        Store store = storeService.findByName(storeName);
        if(store == null){
            store = Store.builder().name(storeName).build();
        }
        purchase.setStore(store);
    }

    private void setProduct(ProductData productData, ProductDTO productDTO){
        Product product = productService.findByName(productDTO.name());
        if(product == null){
            product = Product.builder().name(productDTO.name())
                    .description(productDTO.description()).unit(productDTO.unit()).build();
        }
        productData.setProduct(product);
    }
}
