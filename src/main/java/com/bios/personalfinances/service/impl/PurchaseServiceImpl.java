package com.bios.personalfinances.service.impl;

import com.bios.personalfinances.model.dto.*;
import com.bios.personalfinances.model.entity.*;
import com.bios.personalfinances.model.request.PurchaseRequest;
import com.bios.personalfinances.repository.PaymentMethodRepository;
import com.bios.personalfinances.repository.ProductRepository;
import com.bios.personalfinances.repository.PurchaseRepository;
import com.bios.personalfinances.repository.StoreRepository;
import com.bios.personalfinances.service.CategoryService;
import com.bios.personalfinances.service.PurchaseService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@SuppressWarnings("unused")
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

    @Autowired
    private CategoryService categoryService;

    @Override
    public NewPurchaseDTO newPurchase(PurchaseRequest purchaseRequest) {
        Purchase purchase = Purchase.builder().date(Instant.now()).total(purchaseRequest.total()).build();
        setStore(purchaseRequest.store().getName(), purchase);
        setPaymentMethod(purchaseRequest.paymentMethod().getMethod(), purchase);
        setCategory(purchaseRequest.category(), purchase);
        List<Item> items = new ArrayList<>();
        purchaseRequest.items().forEach(itemDTO -> {
            setPurchaseItem(itemDTO, items);
        });
        purchase.setItems(items);
        Purchase saved = purchaseRepository.save(purchase);
        return modelMapper.map(saved, NewPurchaseDTO.class);
    }

    @Override
    public List<PurchaseItemDTO> getPurchaseList() {
        List<ResultPurchaseItem> purchaseList = purchaseRepository.getPurchaseList();
        List<PurchaseItemDTO> map = modelMapper.map(purchaseList, new TypeToken<List<PurchaseItemDTO>>() {
        }.getType());
        return map;
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

    private void setCategory(CategoryDTO category, Purchase purchase) {
        CategoryDTO savedCategoryDTO = categoryService.findByName(category.getName());
        purchase.setCategory(modelMapper.map(savedCategoryDTO == null? category: savedCategoryDTO, Category.class));
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
