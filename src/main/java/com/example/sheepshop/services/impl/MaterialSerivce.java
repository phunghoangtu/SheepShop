package com.example.sheepshop.services.impl;


import com.example.sheepshop.entitys.Material;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface MaterialSerivce {
    List<Material> getAll();

    void add(Material material);

    void update(Material material);

    Material detail(UUID id);

    Page<Material> getAllPage(Pageable pageable);
}
