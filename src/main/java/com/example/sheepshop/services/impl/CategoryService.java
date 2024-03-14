package com.example.sheepshop.services.impl;


import com.example.sheepshop.entitys.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    List<Category> getAll();

    void add(Category category);

    void update(Category category);

    Category detail(UUID id);

    Page<Category> getAllPage(Pageable pageable);

}
