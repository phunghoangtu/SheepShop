package com.example.sheepshop.services;


import com.example.sheepshop.entitys.HandStyle;
import com.example.sheepshop.repositorys.HandStyleRepository;
import com.example.sheepshop.services.impl.HandStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HandStyleServiceImpl implements HandStyleService {

    @Autowired
    private HandStyleRepository handStyleRepository;

    @Override
    public List<HandStyle> getAll() {
        return handStyleRepository.findAll();
    }

    @Override
    public void add(HandStyle handStyle) {
        handStyleRepository.save(handStyle);
    }

    @Override
    public void update(HandStyle handStyle) {
        handStyleRepository.save(handStyle);
    }

    @Override
    public HandStyle detail(UUID id) {
        return handStyleRepository.getById(id);
    }

    @Override
    public Page<HandStyle> getAllPage(Pageable pageable) {
        return handStyleRepository.findAll(pageable);
    }
}
