package com.example.sheepshop.services.impl;


import com.example.sheepshop.entitys.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface SizeService {
    List<Size> getAll();

    void add(Size size);

    void update(Size size);

    Size detail(UUID id);

    Page<Size> getAllPage(Pageable pageable);
}
