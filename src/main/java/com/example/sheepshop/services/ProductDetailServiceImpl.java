package com.example.sheepshop.services;

import com.example.sheepshop.entitys.ProductDetail;
import com.example.sheepshop.repositorys.ProductDetailRepository;
import com.example.sheepshop.services.impl.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public List<ProductDetail> getAll() {
        return this.productDetailRepository.findAll();
    }

    @Override
    public void add(ProductDetail productDetail) {
        this.productDetailRepository.save(productDetail);
    }

    @Override
    public void update(ProductDetail productDetail) {
        this.productDetailRepository.save(productDetail);
    }

    @Override
    public ProductDetail detail(UUID id) {
        return this.productDetailRepository.findById(id).get();
    }

    @Override
    public Page<ProductDetail> getAllPage(Pageable pageable) {
        return this.productDetailRepository.findAll(pageable);
    }
}
