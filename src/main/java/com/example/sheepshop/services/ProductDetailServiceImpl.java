package com.example.sheepshop.services;

import com.example.sheepshop.entitys.ProductDetail;
import com.example.sheepshop.repositorys.ProductDetailRepository;
import com.example.sheepshop.services.impl.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public Page<ProductDetail> getAll(Pageable pageable) {
        return productDetailRepository.findAll(pageable);
    }

    @Override
    public void add(ProductDetail productDetail) {
        productDetailRepository.save(productDetail);
    }

    @Override
    public void update(ProductDetail productDetail) {
        productDetailRepository.save(productDetail);
    }

    @Override
    public ProductDetail detail(UUID id) {
        return productDetailRepository.getById(id);
    }
}
