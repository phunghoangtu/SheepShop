package com.example.sheepshop.services;

import com.example.sheepshop.entitys.Product;
import com.example.sheepshop.repositorys.ProductRepository;
import com.example.sheepshop.services.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void add(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product detail(UUID id) {
        return productRepository.getById(id);
    }

    @Override
    public Page<Product> getAllPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
