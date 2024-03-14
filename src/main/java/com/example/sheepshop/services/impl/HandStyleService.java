package com.example.sheepshop.services.impl;


import com.example.sheepshop.entitys.HandStyle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface HandStyleService {
    List<HandStyle> getAll();

    void add(HandStyle handStyle);

    void update(HandStyle handStyle);

    HandStyle detail(UUID id);

    Page<HandStyle> getAllPage(Pageable pageable);
}
