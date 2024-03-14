package com.example.sheepshop.services;



import com.example.sheepshop.entitys.Category;
import com.example.sheepshop.repositorys.BrandRepository;
import com.example.sheepshop.repositorys.CategoryRepository;
import com.example.sheepshop.services.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void add(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category detail(UUID id) {
        return categoryRepository.getById(id);
    }

    @Override
    public Page<Category> getAllPage(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
}
