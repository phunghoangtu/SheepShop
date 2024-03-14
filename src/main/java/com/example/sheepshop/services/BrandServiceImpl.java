package com.example.sheepshop.services;


import com.example.sheepshop.entitys.Brand;
import com.example.sheepshop.repositorys.BrandRepository;
import com.example.sheepshop.services.impl.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BrandServiceImpl implements BrandService{

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public void add(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public void update(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public Brand detail(UUID id) {
        return brandRepository.getById(id);
    }

    @Override
    public Page<Brand> getAllPage(Pageable pageable) {
        return brandRepository.findAll(pageable);
    }
}
