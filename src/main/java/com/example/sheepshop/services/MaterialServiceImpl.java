package com.example.sheepshop.services;


import com.example.sheepshop.entitys.Material;
import com.example.sheepshop.repositorys.MaterialRepository;
import com.example.sheepshop.services.impl.MaterialSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MaterialServiceImpl implements MaterialSerivce {

    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public List<Material> getAll() {
        return materialRepository.findAll();
    }

    @Override
    public void add(Material material) {
        materialRepository.save(material);
    }

    @Override
    public void update(Material material) {
        materialRepository.save(material);
    }

    @Override
    public Material detail(UUID id) {
        return materialRepository.getById(id);
    }

    @Override
    public Page<Material> getAllPage(Pageable pageable) {
        return materialRepository.findAll(pageable);
    }
}
