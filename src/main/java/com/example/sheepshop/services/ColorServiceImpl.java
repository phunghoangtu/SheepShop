package com.example.sheepshop.services;


import com.example.sheepshop.entitys.Color;
import com.example.sheepshop.repositorys.ColorRepository;
import com.example.sheepshop.services.impl.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public List<Color> getAll() {
        return colorRepository.findAll();
    }

    @Override
    public void add(Color color) {
        colorRepository.save(color);
    }

    @Override
    public void update(Color color) {
        colorRepository.save(color);
    }

    @Override
    public Color detail(UUID id) {
        return colorRepository.getById(id);
    }

    @Override
    public Page<Color> getAllPage(Pageable pageable) {
        return colorRepository.findAll(pageable);
    }
}
