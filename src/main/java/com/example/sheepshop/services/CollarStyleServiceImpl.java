package com.example.sheepshop.services;


import com.example.sheepshop.entitys.CollarStyle;
import com.example.sheepshop.repositorys.CollarStyleRepository;
import com.example.sheepshop.services.impl.CollarStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CollarStyleServiceImpl implements CollarStyleService {

    @Autowired
    private CollarStyleRepository collarStyleRepository;

    @Override
    public List<CollarStyle> getAll() {
        return collarStyleRepository.findAll();
    }

    @Override
    public void add(CollarStyle collarStyle) {
        collarStyleRepository.save(collarStyle);
    }

    @Override
    public void update(CollarStyle collarStyle) {
        collarStyleRepository.save(collarStyle);
    }

    @Override
    public CollarStyle detail(UUID id) {
        return collarStyleRepository.getById(id);
    }

    @Override
    public Page<CollarStyle> getAllPage(Pageable pageable) {
        return collarStyleRepository.findAll(pageable);
    }
}
