package com.example.sheepshop.services.impl;


import com.example.sheepshop.entitys.CollarStyle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CollarStyleService {
    List<CollarStyle> getAll();

    void add(CollarStyle collarStyle);

    void update(CollarStyle collarStyle);

    CollarStyle detail(UUID id);

    Page<CollarStyle> getAllPage(Pageable pageable);
}
