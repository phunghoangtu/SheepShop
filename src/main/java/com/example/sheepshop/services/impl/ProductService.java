package com.example.sheepshop.services.impl;

import com.example.sheepshop.entitys.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> getAll();

    void add(Product product);

    void update(Product product);

    Product detail(UUID id);

    Page<Product> getAllPage(Pageable pageable);
}
