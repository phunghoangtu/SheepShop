package com.example.sheepshop.services.impl;


import com.example.sheepshop.entitys.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface BrandService {

    List<Brand> getAll();

    void add(Brand brand);

    void update(Brand brand);

    Brand detail(UUID id);

    Page<Brand> getAllPage(Pageable pageable);

}
