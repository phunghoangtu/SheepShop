package com.example.sheepshop.services.impl;


import com.example.sheepshop.entitys.Color;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ColorService {
    List<Color> getAll();

    void add(Color color);

    void update(Color color);

    Color detail(UUID id);

    Page<Color> getAllPage(Pageable pageable);
}
