package com.example.sheepshop.services.impl;

import com.example.sheepshop.entitys.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProductDetailService {

    Page<ProductDetail> getAll(Pageable pageable);

    void add(ProductDetail productDetail);

    void update(ProductDetail productDetail);

    ProductDetail detail(UUID id);

}
