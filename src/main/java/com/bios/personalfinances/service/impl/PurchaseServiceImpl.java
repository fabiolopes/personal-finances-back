package com.bios.personalfinances.service.impl;

import com.bios.personalfinances.model.entity.*;
import com.bios.personalfinances.model.entity.dto.ItemDTO;
import com.bios.personalfinances.model.entity.dto.NewPurchaseDTO;
import com.bios.personalfinances.model.entity.dto.ProductDTO;
import com.bios.personalfinances.model.entity.request.PurchaseRequest;
import com.bios.personalfinances.repository.PaymentMethodRepository;
import com.bios.personalfinances.repository.ProductRepository;
import com.bios.personalfinances.repository.PurchaseRepository;
import com.bios.personalfinances.repository.StoreRepository;
import com.bios.personalfinances.service.ProductService;
import com.bios.personalfinances.service.PurchaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public NewPurchaseDTO newPurchase(PurchaseRequest purchaseRequest) {
        Purchase purchase = Purchase.builder().date(Instant.now()).total(purchaseRequest.total()).build();
        setStore(purchaseRequest.store().getName(), purchase);
        setPaymentMethod(purchaseRequest.paymentMethod().getMethod(), purchase);
        List<Item> items = new ArrayList<>();
        purchaseRequest.items().stream().forEach(itemDTO -> {
            setPurchaseItem(itemDTO, items);
        });
        purchase.setItems(items);
        Purchase saved = purchaseRepository.save(purchase);
        return modelMapper.map(saved, NewPurchaseDTO.class);
    }

    private void setPurchaseItem(ItemDTO itemDTO, List<Item> items){
        ProductData productData = ProductData.builder().price(itemDTO.price())
                .referenceDate(LocalDate.now()).build();
        setProduct(productData, itemDTO.product());
        Item item = Item.builder().valuePaid(itemDTO.valuePaid()).qtd(itemDTO.qtd())
                .date(Instant.now()).productData(productData).build();
        items.add(item);
    }

    private void setPaymentMethod(String method, Purchase purchase) {
        PaymentMethod paymentMethod = paymentMethodRepository.findByMethod(method);
        if(paymentMethod == null){
            paymentMethod = PaymentMethod.builder().method(method).build();
        }
        purchase.setPaymentMethod(paymentMethod);
    }

    private void setStore(String storeName, Purchase purchase){
        Store store = storeRepository.findByName(storeName);
        if(store == null){
            store = Store.builder().name(storeName).build();
        }
        purchase.setStore(store);
    }

    private void setProduct(ProductData productData, ProductDTO productDTO){
        Product product = productRepository.findByName(productDTO.getName());
        if(product == null){
            product = Product.builder().name(productDTO.getName())
                    .description(productDTO.getDescription()).unit(productDTO.getUnit()).build();
        }
        productData.setProduct(product);
    }
}
