package com.bios.personalfinances.service.impl;

import com.bios.personalfinances.model.dto.*;
import com.bios.personalfinances.model.entity.*;
import com.bios.personalfinances.model.request.PurchaseRequest;
import com.bios.personalfinances.repository.*;
import com.bios.personalfinances.service.PurchaseService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private CategoryRepository categoryRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private  ProductDataRepository productDataRepository;

    @Override
    @Transactional
    public NewPurchaseDTO newPurchase(PurchaseRequest purchaseRequest) {
        Purchase purchase = Purchase.builder().date(Instant.now()).total(purchaseRequest.total()).build();
        setStore(purchaseRequest.store().getName(), purchase);
        setPaymentMethod(purchaseRequest.paymentMethod().getName(), purchase);
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
        productData = productDataRepository.save(productData);
        Item item = itemRepository.save(Item.builder().valuePaid(itemDTO.valuePaid()).qtd(itemDTO.qtd())
                .date(Instant.now()).productData(productData).build());
        items.add(item);
    }

    private void setPaymentMethod(String name, Purchase purchase) {
        PaymentMethod paymentMethod = paymentMethodRepository.findByName(name);
        if(paymentMethod == null){
            paymentMethod = paymentMethodRepository.save(PaymentMethod.builder().name(name).build());
        }
        purchase.setPaymentMethod(paymentMethod);
    }

    private void setStore(String storeName, Purchase purchase){
        Store store = storeRepository.findByName(storeName);
        if(store == null){
            store = storeRepository.save(Store.builder().name(storeName).build());
        }
        purchase.setStore(store);
    }

    private void setCategory(CategoryDTO category, Purchase purchase) {
        Category savedCategory = categoryRepository.findByName(category.getName());
        if(savedCategory == null) {
            savedCategory = categoryRepository.save(Category.builder().name(category.getName()).build());
        }
        purchase.setCategory(savedCategory);
    }

    private void setProduct(ProductData productData, ProductDTO productDTO){
        Product product = productRepository.findByName(productDTO.getName());
        if(product == null){
            product = productRepository.save(Product.builder().name(productDTO.getName())
                    .description(productDTO.getDescription()).unit(productDTO.getUnit()).build());
        }
        productData.setProduct(product);
    }
}
